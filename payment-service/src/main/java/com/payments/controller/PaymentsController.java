// package name 
package com.payments.controller;

// importing files
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payments.entity.PaymentRequest;
import com.payments.service.CreditCardsPaymentService;

@RestController
public class PaymentsController {
	@Autowired
	private CreditCardsPaymentService cardsPaymentService;

	@PostMapping("/completepayment")
	public ResponseEntity<String> completePayment(@RequestBody PaymentRequest paymentRequest) {
		boolean validCardDetails = cardsPaymentService.validateCredentialandLimit(paymentRequest.getCardNumber(),
				paymentRequest.getCvv(), paymentRequest.getAmount());
		if (validCardDetails)
			return new ResponseEntity<>("Great! Payment Successfull", HttpStatus.OK);

		return new ResponseEntity<>("Payment Failed! please check the credentials and limit", HttpStatus.BAD_REQUEST);
	}
}
