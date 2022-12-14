//package name 
package com.packaginganddelivery;

// import statement 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// starting the appcliation 
@SpringBootApplication
@EnableFeignClients
@EnableWebMvc
public class PackagingAndDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagingAndDeliveryApplication.class, args);
	}

}
