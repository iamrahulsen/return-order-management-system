// package name 
package com.componentprocessing.feign;

// importing the packages
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.componentprocessing.model.PaymentRequest;

// making a proxy to interact with payment microservices
@Component
@FeignClient(name="PAYMENTS-MICROSERVICE")
public interface PaymentServiceFeignClient {

	// accessing the end point of payment microservices
	@PostMapping("/completepayment")
	public ResponseEntity<String> completePayment(@RequestBody PaymentRequest paymentRequest);
}
