// package
package com.authorization.model;

//importing required modules
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// a model to capture the username and password returned from the frontend
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticationRequest {

	private String userName; // capturing the username
	private String password; // capturing the password

}
