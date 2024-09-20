package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentJpaMsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentJpaMsqlApplication.class, args);
		
		System.out.println("Student springBoot started...");
	}

}
