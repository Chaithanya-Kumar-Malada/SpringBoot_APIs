package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageUsingJpaMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageUsingJpaMySqlApplication.class, args);
		
		System.out.println("hello Started");
	}

}
