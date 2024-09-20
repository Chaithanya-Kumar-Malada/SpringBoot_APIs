package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Sample {

	public void display() {
		System.out.println("This is my spring boot Sample class output ");
	}
}

@Component
 class Demos{
	
	 public void demoMethod() {
			System.out.println("This is my spring boot demos class output ");
		}
}