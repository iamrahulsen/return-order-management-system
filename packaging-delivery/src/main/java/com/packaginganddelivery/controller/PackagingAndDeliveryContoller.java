// package name 
package com.packaginganddelivery.controller;

// importing the files
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packaginganddelivery.service.PackageDeliveryCalculator;

@RestController
public class PackagingAndDeliveryContoller {
	@Autowired
	PackageDeliveryCalculator packageDeliveryCalculator;
	
	@GetMapping("/GetPackagingDeliveryCharge")
	public ResponseEntity<Double> getPackagingDeliveryCharges(String componentType , int quantity) throws Exception {
		return new ResponseEntity<>(packageDeliveryCalculator.getPrice(componentType, quantity),HttpStatus.OK);
	}

}
