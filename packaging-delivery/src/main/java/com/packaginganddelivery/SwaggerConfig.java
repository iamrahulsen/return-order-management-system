package com.packaginganddelivery;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean 
	public Docket swaggerCongiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .apis(RequestHandlerSelectors.basePackage("com.packaginganddelivery"))
				   .build()
				   .apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
		return new ApiInfo("Package-devlivery-processing-API",
				"To Get the detials of the package and delivery",
				"1.1",
				"Terms & Conditions here",
				new Contact("Rahul Sen", "https://www.linkedin.com/in/iamrahulsen/", "iamrahulsen100@gmail.com"),
				"FSE Project", "2022", Collections.emptyList());
	}

}
