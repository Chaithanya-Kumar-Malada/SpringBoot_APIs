package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary                              //  to avoid multiply beans allowed to one instance
                                      //  and to make single allowed to one instance.
public class Dog implements Animal {

	public void Sound() {
		System.out.println("Dog makes Sound bow bow ");
	}
	
}
