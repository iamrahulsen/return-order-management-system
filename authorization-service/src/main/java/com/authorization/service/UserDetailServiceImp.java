// package 
package com.authorization.service;

// importing the required packages
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authorization.repository.UserRepository;


// for verifying the database which is used and fetching the data 
@Service
public class UserDetailServiceImp implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	// returning the userdetails 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

}
