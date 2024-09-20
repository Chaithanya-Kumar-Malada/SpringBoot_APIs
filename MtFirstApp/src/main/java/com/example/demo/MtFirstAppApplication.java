package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MtFirstAppApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext obj = SpringApplication.run(MtFirstAppApplication.class, args);
		
		Sample s1 = obj.getBean(Sample.class);
		Demos s2 = obj.getBean(Demos.class);
		
//		Sample s1 = new Sample();  // Normally we create object and call its method.
		
		s1.display();
		s2.demoMethod();
		
		//System.out.println("This is my spring boot output ");
		
		
//		Dog d = obj.getBean(Dog.class);       // Normally method
//		Cat c =obj.getBean(Cat.class);
//		d.Sound();
//		c.Sound();
		
//  	Creating bean for AnimalController ......
		
		AnimalController ac = obj.getBean(AnimalController.class);
		
		ac.display();
		
		
		
		
		
	}

}
