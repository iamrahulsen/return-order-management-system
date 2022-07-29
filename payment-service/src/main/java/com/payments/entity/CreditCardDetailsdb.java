// package name 
package com.payments.entity;

// importing files
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// CreditCardDetails DB
@Entity(name = "CREDIT_CARD_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDetailsdb {
	@Id
	@Column(nullable =false )
	private Long cardNumber;
	@Column(nullable =false )
	private int cvv;
	@Column(nullable =false )
	private double credit;

}
