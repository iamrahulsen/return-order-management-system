// package name 
package com.componentprocessing.contoller;

// imporing packages
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.componentprocessing.feign.AuthorizationFeignClient;
import com.componentprocessing.feign.PaymentServiceFeignClient;
import com.componentprocessing.model.PaymentRequest;
import com.componentprocessing.model.ProcessRequest;
import com.componentprocessing.model.ProcessResponse;
import com.componentprocessing.service.OrderProcessingService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@Slf4j
@RestController
public class ComponentProcessingController {

	@Autowired
	private PaymentServiceFeignClient paymentServiceFeignClient;
	@Autowired
	private AuthorizationFeignClient authorizationFeignClient;
	@Autowired
	private OrderProcessingService orderService;

	@GetMapping("/processdetail")
	public ResponseEntity<ProcessResponse> processDetails(@RequestHeader("Authorization") String authToken,
			ProcessRequest processRequest) {
		authorizationFeignClient.validateToken(authToken);
		return new ResponseEntity<>(orderService.processOrder(processRequest), HttpStatus.CREATED);
	}

	// does the payment through the payment microservice
	@PostMapping("/completeprocessing")
	public ResponseEntity<String> completePayment(@RequestHeader("Authorization") String authToken, String requestId,
			@RequestBody PaymentRequest paymentRequest) {
		authorizationFeignClient.validateToken(authToken);
		log.info("Sending payment request to payment microservice");
		ResponseEntity<String> response;

		response = paymentServiceFeignClient.completePayment(paymentRequest);

		return response;
	}

}
