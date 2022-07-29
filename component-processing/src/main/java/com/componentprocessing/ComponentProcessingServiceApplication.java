// package name 
package com.componentprocessing;

// importing the required packages
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.componentprocessing.exception.FeignErrorDecoder;

@SpringBootApplication
@EnableFeignClients
@EnableWebMvc
public class ComponentProcessingServiceApplication {
	
	// starts the application
	public static void main(String[] args) {
		SpringApplication.run(ComponentProcessingServiceApplication.class, args);
	}
	
	// defining the bean implementation 
	@Bean
    public FeignErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }
	

}
