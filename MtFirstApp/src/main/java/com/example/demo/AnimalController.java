package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class AnimalController {
	
	Animal animal;

	public AnimalController(  Animal animal) {
		this.animal = animal;
	}
	
	
// 		 To avoid multiply beans allowed to one instance and to make single allowed to one instance.

//		public AnimalController(@Qualifier("cat")  Animal animal) {
//			this.animal = animal;
//		}
	
	
	public void display() {
		animal.Sound();
	}

}
