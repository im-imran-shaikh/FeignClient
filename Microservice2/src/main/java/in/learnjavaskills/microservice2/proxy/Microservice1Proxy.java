package in.learnjavaskills.microservice2.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "microservice1", url = "http://localhost:8090")
public interface Microservice1Proxy
{
	@GetMapping("/message/{message}")
	public String message(@RequestHeader(value = "Authorization", required = true) String authorization, @PathVariable String message);
}
