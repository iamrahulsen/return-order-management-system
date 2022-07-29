// package name 
package com.payments.service;

// importing files
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.entity.CreditCardDetailsdb;
import com.payments.repo.CreditCardRepository;

@Service
public class CreditCardsPaymentService {

	@Autowired
	private CreditCardRepository creditCardRepository;

	//checking for valid credentials and limit of the card details 
	public boolean validateCredentialandLimit(Long cardNumber, int cvv, double amount) {

		// if the detials are present in the database or not
		Optional<CreditCardDetailsdb> details = creditCardRepository.findById(cardNumber);
		if (details.isPresent()) {
			CreditCardDetailsdb creditCardDetails = details.get();
			if (creditCardDetails.getCvv() == cvv && creditCardDetails.getCredit() >= amount) {
				creditCardDetails.setCredit(creditCardDetails.getCredit() - amount);
				creditCardRepository.save(creditCardDetails);
				return true;
			}
		}
		return false;

	}

}
