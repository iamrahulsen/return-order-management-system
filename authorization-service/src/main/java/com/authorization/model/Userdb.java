//package
package com.authorization.model;

// importing the required packages
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// making the inmemory database called user to store the details of the user registered with the website 
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Userdb implements UserDetails 
{
	// for the autogeneration of ID
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String password;
	private String role;
	
	
	// setting up the getter and setters 
	
	@Override
	public String getPassword() 
	{
		return password;
	}
	
	@Override
	public String getUsername() 
	{
		return username;
	}
	
	@Override
	public boolean isEnabled() 
	{
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}
	
	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return Collections.emptyList();
	}


}
