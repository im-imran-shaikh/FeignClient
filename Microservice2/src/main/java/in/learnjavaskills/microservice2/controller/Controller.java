package in.learnjavaskills.microservice2.controller;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.learnjavaskills.microservice2.proxy.Microservice1Proxy;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controller
{
	private final Microservice1Proxy microservice1Proxy;
	
	@GetMapping("/message-from-microservice2")
	public String message(@RequestParam String message)
	{
		return microservice1Proxy.message(authorizationToken("imran", "shaikh"), message);
	}
	
	private String authorizationToken(String username, String password)
	{
		String credentials = username + ":" + password;
		byte[] encode = Base64.getEncoder().encode(credentials.getBytes());
		String authorizaion = "Basic " + new String(encode);
		return authorizaion;
	}
}
