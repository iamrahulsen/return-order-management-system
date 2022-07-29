// packages 
package com.authorization.controller;

// importing the required modules 
import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.authorization.model.AuthenticationRequest;
import com.authorization.model.AuthenticationResponse;
import com.authorization.security.JwtUtil;
import com.authorization.service.UserDetailServiceImp;

import lombok.extern.slf4j.Slf4j;

// dispacher-servlet
@RestController
@CrossOrigin("*")
// for including the loggers 
@Slf4j
public class AuthController {
	// auto wiring required beans
	@Autowired
	private UserDetailServiceImp userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtTokenUtil;

	// get the details from the frontend and verify the detials
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		// verifing if the user is registerd with the portal or not and handling
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad_loginDetails");
		}

		// storing the details
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		// generation of the jwt token with the user details
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	// validation of the jwt token for every api request
	@GetMapping("/validate")
	protected boolean validateToken(@RequestHeader(value = "Authorization") String token)
			throws ServletException, IOException {

		return true;
	}

}