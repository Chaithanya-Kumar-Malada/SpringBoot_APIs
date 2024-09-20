package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_Controller {

	List<Student> StudentList = new ArrayList<>(Arrays.asList(
			                     new Student(1,"Surya",83.0,24),
			                     new Student(2,"arya",30.0,25),
			                     new Student(3,"kodi",60.0,26),
			                     new Student(4,"Sumo",45.0,22)    ));
	

	@GetMapping("/students")
	public List<Student> StudentList(){
		return StudentList;
	}
	
	@GetMapping("/student/{rollNo}")
	public Student getstd(@PathVariable int rollNo) {
		
//for(Student i:StudentList) {
//			
//			if(i.getRollno().equals(rollNo)) {		
//				return  i;
//			}
//		}
//		return null ;
		
		Student s1 = StudentList.stream().filter(i->i.getRollno()==rollNo).findFirst().get() ;
		
		return s1 ;
	}
	
	@GetMapping("/passed")
	public List<Student> passedStd(){
		
	  List<Student> p1 = StudentList.stream().filter(i->i.getMarks()>50).collect(Collectors.toList());
	  return p1;
	}
	
	@GetMapping("/failed")
	public List<Student> failedstd(){
		
		List<Student> f1 = StudentList.stream().filter(i->i.getMarks()<50).collect(Collectors.toList());
		return f1;
	}
	
	
	@GetMapping("/name/marks")
	public List<String> namemarks(){
		
		List<String> n1 = StudentList.stream().map(i->i.getName()+ " - "+ i.getMarks()).collect(Collectors.toList());
				
		return n1;
	
	}
	
	@PostMapping("/addstudent")
	public String addstd( @RequestBody Student s1) {
		
		StudentList.add(s1);
		return "Student added Succesfully";
	}
	
	
	@PutMapping("/update/{rollNo}")
	public String updatestd(@PathVariable int rollNo, @RequestBody Student s1) {
		
		Student existingstd = StudentList.stream().filter(i->i.getRollno()==rollNo).findFirst().get();		
		
		existingstd.setRollno(s1.getRollno());
		existingstd.setName(s1.getName());
		existingstd.setMarks(s1.getMarks());
		existingstd.setAge(s1.getAge());
		
		
		return "Student Updated sucessfully ";
	}
	
	
	
	@DeleteMapping("/delete/{rollNo}")
	public String deletestd(@PathVariable int rollNo) {
			
	  StudentList.removeIf(i->i.getRollno()==rollNo);
	  
		return "Student deleted success! ";
		
	}
	
	
	
	
	
	
	
	
}
