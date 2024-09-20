package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

	@RequestMapping("/name")
	public String show() {
		return "Hello Ram ";
	}
	
	@RequestMapping("/name1")
	public String show1() {
		return "Hello Surya ";
	}
	
	@RequestMapping("/getname/{name}/{ages}")
	public String getname(@PathVariable String name,@PathVariable int ages) {
		return "Hello  "+ name +ages;
	}
	
	@RequestMapping("/getname")
	public String showname(@RequestParam String name,@RequestParam int ages) {
		
		return "Hello " + name + ages; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
