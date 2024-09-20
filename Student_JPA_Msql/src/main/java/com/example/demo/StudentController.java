package com.example.demo;

import java.rmi.StubNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.StudentNotFound;

@RestController
public class StudentController {

	@Autowired
	StudentService stdser;
	
	@GetMapping("/students")
		public List<Student> getallStd(){
			return stdser.getallStudents();
		}
	
   @GetMapping("/student/{id}")
   		public Student getstdById(@PathVariable long id) throws StudentNotFound {
	   
	   return stdser.getstdById(id);
	   
   }
	
	@PostMapping("/student")
		public String poststd(@RequestBody Student s1) throws StudentNotFound {
			return stdser.postStudent(s1);
		}
	
	@PutMapping("/student/{id}")
		public String updatestd(@PathVariable long id, @RequestBody Student s1) {
		
		return stdser.updatestd(id,s1);
	}
	
	@DeleteMapping("/student/{id}")
		public String deletestd(@PathVariable long id) {
		return stdser.deletestd(id);
	}
	
	
	
	
	
	
	
}
