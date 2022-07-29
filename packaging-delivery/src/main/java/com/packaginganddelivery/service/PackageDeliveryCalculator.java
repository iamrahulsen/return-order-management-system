// package name 
package com.packaginganddelivery.service;

// importing files 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.packaginganddelivery.exception.InvalidInputDetailsException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PackageDeliveryCalculator {
	@Value("${packagecost.integral}")
	private double packagechargeintegral;
	@Value("${packagecost.accessory}")
	private double packagechargeaccessory;
	@Value("${deliverycharge.integral}")
	private double deliverychargeintegral;
	@Value("${deliverycharge.accessory}")
	private double deliverychargeaccessory;
	@Value("${sheatcost}")
	private double sheatcost;

	public double getPrice(String componentType, int quantity) throws Exception {

		double totalcharge;
		// checking the quantity should be greater than zero
		if (quantity <= 0) {
			log.error("Ordered Quantity should be greater than 0");
			throw new InvalidInputDetailsException("Invalid quantity! " + quantity);
		}

		// different type of component
		switch (componentType.toLowerCase()) {
		case "accessory":
			totalcharge = (packagechargeaccessory + deliverychargeaccessory + sheatcost) * quantity;
			break;
		case "integral":
			totalcharge = (packagechargeintegral + deliverychargeintegral + sheatcost) * quantity;
			break;

		default: {
			log.error("Entered Component is not a valid type");
			throw new InvalidInputDetailsException("Invalid Component Type " + componentType);
		}
		}

		return totalcharge;
	}

}
