package com.example.demo;

import org.springframework.stereotype.Component;

@Component

public class Cat implements Animal {

	
	public void Sound() {
		System.out.println("Cat makes Meow meow ");
	}
	
}
