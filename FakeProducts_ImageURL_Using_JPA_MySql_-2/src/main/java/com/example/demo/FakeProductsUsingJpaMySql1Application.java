package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FakeProductsUsingJpaMySql1Application {

	public static void main(String[] args) {
		SpringApplication.run(FakeProductsUsingJpaMySql1Application.class, args);
		System.out.println("Fake products using Images started.....");
	}

}
