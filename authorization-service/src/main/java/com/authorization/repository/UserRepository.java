// package
package com.authorization.repository;

// importing required modules
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authorization.model.Userdb;

// creating repository for performing CRUD operation on the User datbase 
@Repository
public interface UserRepository extends JpaRepository<Userdb, String> 
{

	// finding the detatils through username 
	public Userdb findByUsername(String username);
}
