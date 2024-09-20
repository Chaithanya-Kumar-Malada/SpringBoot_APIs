package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User> findByPhonenoAndPassword(String phoneno,String password);
	
	Optional<User> findByPhoneno(String phoneno);

//	public boolean existByPhoneno(String phoneno);
//	public boolean existsByPassword(String password);

	
	
}
