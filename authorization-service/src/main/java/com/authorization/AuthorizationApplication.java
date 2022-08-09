// package 
package com.authorization;

// importing required modules
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.authorization.model.Userdb;
import com.authorization.repository.UserRepository;

// spring boot applicaiton 
@SpringBootApplication
public class AuthorizationApplication {
	
	// auto wiring required bean
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// staring the application 
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

	// inserting the user into the User database 
	@PostConstruct	
	public void initUsers() {
		List<Userdb> users =Stream.of(
				new Userdb("rahulsen", passwordEncoder.encode("rahul@1"), "ROLE_USER"),
				new Userdb("rumpasen", passwordEncoder.encode("rumpa@1"), "ROLE_USER"),
				new Userdb("tarik", passwordEncoder.encode("tarik@1"), "ROLE_USER"),
				new Userdb("mehtab", passwordEncoder.encode("mehtab@1"), "ROLE_USER"),
				new Userdb("rupansen", passwordEncoder.encode("rupan@1"), "ROLE_USER"),
				new Userdb("rumasen", passwordEncoder.encode("ruma@1"), "ROLE_USER"),
				new Userdb("rock", passwordEncoder.encode("rock@123"), "ROLE_USER")
				).collect(Collectors.toList());
		
		// saving the details into the database 
		repository.saveAll(users);
		
	}
}
