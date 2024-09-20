package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserLoginRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLoginRegisterApplication.class, args);
		
		System.out.println("Spring Boot Started ");
	}

}
