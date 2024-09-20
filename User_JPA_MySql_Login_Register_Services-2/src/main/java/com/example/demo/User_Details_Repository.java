package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Details_Repository extends JpaRepository<UserDetails, Long> {

	
	Optional<UserDetails> findByPhoneno(String phoneno);
	
	Optional<UserDetails> findByPhonenoAndPassword(String phoneno,String password);
	
	//Optional<User> findByPhonenoAndPassword(String phoneno,String password);
	
}
