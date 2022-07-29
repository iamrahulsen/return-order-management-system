// package name 
package com.payments.entity;

// importing files
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Model or holding the details of the transaction 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
	private  Long cardNumber; // card number
	private  int cvv; // cvv of the card
	private  double amount; // amount of the transaction 
	
}
