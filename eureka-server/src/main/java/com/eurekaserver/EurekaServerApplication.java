// package name 
package com.eurekaserver;

// importing package
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// starting the application 
@SpringBootApplication
// enabling the eureka server 
@EnableEurekaServer
public class EurekaServerApplication {

	// application starts here
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
