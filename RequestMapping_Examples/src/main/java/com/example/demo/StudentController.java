package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class StudentController {

	
	List<Student> StudentList = new ArrayList<>(
			
			Arrays.asList(
					new Student(1,"Surya",24),
					new Student(2,"Chai",23) ,
					new Student(3,"Lav",16) 
					));
			
	

	

	@RequestMapping("/students")
	public List<Student> getstd(){
		
		return  StudentList ;
	}
	
	@RequestMapping("/names")
	public List<String> getnames(){
		List<String> names = StudentList.stream().map(i ->i.getNam()).collect(Collectors.toList());
		return  names ;
	}
	
	@RequestMapping("/ageLimit")
	public List<Student> ageLimit(){
		List<Student> ageLimit = StudentList.stream().filter(i -> i.getAge()>18).collect(Collectors.toList());
		return  ageLimit ;
	}
	
	@RequestMapping("/length")
	public int Length(){
		int len = StudentList.size();
		return  len ;
	}


	@RequestMapping("/sort")
	public List<Student> sorting(){
		List<Student> sort = StudentList.stream().sorted(Comparator.comparing(i->i.getNam())).collect(Collectors.toList());
		return sort;
	}
	
	
	// Creating new Student
	
	@PostMapping("/addstudent")
	public String addstd( @RequestBody Student s1) {
		
		StudentList.add(s1);
		return " Student added to the List Succesfully";
	}
	
	// Updating Student
	
	@PutMapping("/updateStd/{rollNo}")
	public String updatestd(@PathVariable int rollNo, @RequestBody Student s1) {
		
	 Student existingByRoll = StudentList.stream().filter(i->i.getRollno()==rollNo).findFirst().get() ;
	
	 		existingByRoll.setRollno(s1.getRollno());
	 		existingByRoll.setNam(s1.getNam());
	 		existingByRoll.setAge(s1.getAge());
	 
		return "Student updated!";
	}
	
	
	@DeleteMapping("/deletestd/{rollNo}")
	public String deletestd ( @PathVariable int rollNo) {
		
		StudentList.removeIf(i->i.getRollno()==rollNo);
		
		return "Student deleted successfully";
	}
	
	
	
	//  	Patching only rollNO
	
	@PatchMapping("/patchStd/{rollNo}")
	public String patchstd(@PathVariable int rollNo, @RequestBody int s1) {
		
	 Student existingByRoll = StudentList.stream().filter(i->i.getRollno()==rollNo).findFirst().get();
	
	 		existingByRoll.setRollno(s1);
	 
		return "Student patch updated!";
	}
	
	@PatchMapping("/patchStd/name/{rollNo}")
	public String patchnam( @PathVariable int rollNo , @RequestBody String s) {
		
	  Student existingName =	StudentList.stream().filter(i->i.getRollno()==rollNo).findFirst().get();
	  
	  existingName.setNam(s);
	  
		return "Student patch updated!"; 
	}
	
	
	
}
