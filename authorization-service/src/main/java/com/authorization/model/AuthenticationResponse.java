// package
package com.authorization.model;

//importing required modules
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// a model to capture the jwt token
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

	private String jwt; // jwt token will be captured here

}
