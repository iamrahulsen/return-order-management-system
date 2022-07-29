// package name 
package com.componentprocessing.feign;

// import statement
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

// proxy for interaction with authorization microservices
@Component
@FeignClient(name="AUTHORIZATION-SERVER")
public interface AuthorizationFeignClient {

	// access /validate endpoint in autorization microservices 
	@GetMapping("/validate")
	 public boolean validateToken(@RequestHeader(value="Authorization") String token);
	
}
