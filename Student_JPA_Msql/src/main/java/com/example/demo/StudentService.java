package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.StudentNotFound;

@Service
public class StudentService {

	@Autowired
	StudentRepository stdrepo;
	
	public List<Student> getallStudents(){
		return stdrepo.findAll();
	}
	
	
	public Student getstdById(long id) throws StudentNotFound {
		
		Student existing = stdrepo.findById(id).orElse(null);
		
		if(existing == null) {
			throw new StudentNotFound("Student Not Found for this Id - "+ id +" Try with another ID" );
		}
		return existing;
	}
	
	
	
	public String postStudent(Student s1) throws StudentNotFound {
		
		Student existing = stdrepo.findById(s1.getId()).orElse(null);
		
		if(existing != null) {
			throw new StudentNotFound("Student Already exits with ID");
		}
		stdrepo.save(s1);
		return "Student Saved Successfully";
	}
	
	public String updatestd(long id, Student s1) {
		Student existing = stdrepo.findById(id).orElse(null);
		
			existing.setName(s1.getName());
			existing.setGender(s1.getGender());
			existing.setAge(s1.getAge());
			stdrepo.save(existing);
		return "Student updated sucessfully";
	}
	
	public String deletestd(Long id) {
		stdrepo.deleteById(id);
		return "Student deleted Sucessfully";
	}


	


	
	
	
}
