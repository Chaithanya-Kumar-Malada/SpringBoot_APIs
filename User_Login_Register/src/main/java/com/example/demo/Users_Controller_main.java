package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Users_Controller_main {

	
	List<Users> userList = new ArrayList<>();
	
	
	@GetMapping("/users")
	public List<Users> getUsers() {
		
		return userList;
	}
	
	
	@GetMapping("/user/{phoneNo}")
	public Users getUserByPhoneno(@PathVariable long phoneNo) {
	
		for(Users i:userList) {
			
			if(i.getPhoneno().equals(phoneNo)) {		
				return  i;
			}
		}
		return null ;
	}
	
	@PostMapping("/user/register")
	public String UserRegister( @RequestBody Users u1) {
		
		for(Users i:userList) {
			
			if(i.getPhoneno().equals(u1.getPhoneno())) {
				return " User already registered with Phone no ";
			}
		}
		
		
		if(u1.getName() == null || u1.getPhoneno() == null || u1.getEmail()==null || u1.getPassword()==null) {
			return "Enter all the Values : Name,PhoneNo,Email,Password ";
			
		}else {
			userList.add(u1);
			return "User Registered Successfully";
		}
	}
	
	
	@PostMapping("/user/login")
	public String login(@RequestBody Users u1 ) {
		
		for(Users i : userList) {

			if(i.getPhoneno().equals(u1.getPhoneno()) && i.getPassword().equals(u1.getPassword()) ) {
				return "Login Successfull";
			}
		}
		return "Invalid Phone no or Password ";
	}
	
	
	@PutMapping("/user/update/{phoneNo}")
	public String userupdate(@PathVariable long phoneNo, @RequestBody Users u1) {
		
		for(Users i: userList) {
			
			if(i.getPhoneno().equals(phoneNo)) {
				
//				i.setName(u1.getName());
//				i.setEmail(u1.getEmail());
//				i.setPassword(u1.getPassword());
				
				userList.set(0, u1);
				
				return " User details Updated Successfully";
			}	
		}
		
		return "User with Phone no "+ phoneNo + " not Found";
	}
	
	
	@PatchMapping("/user/update/{phoneNo}")
	public String partiallyupdate(@PathVariable long phoneNo,@RequestBody Users u1) {
		
		for(Users i:userList) {
			
			if(i.getPhoneno().equals(phoneNo)) {
			
				// Only update fields that are present in the Request 
				
				if(u1.getName() != null) {
					i.setName(u1.getName());
				}
				if(u1.getEmail() != null) {
					i.setEmail(u1.getEmail());
				}
				if(u1.getPassword() != null) {
					i.setPassword(u1.getPassword());
				}
				
				
				return "User details partially updated successfully";
			}
		}

		return " User with Phone no "+ phoneNo + " not found ";
		
	}
	
	
	
	@DeleteMapping("/user/delete/{phoneNo}")
	public String deleteuser(@PathVariable long phoneNo) {
		
		for(Users i: userList) {
			
			if(i.getPhoneno().equals(phoneNo)) {
				
				userList.remove(i);
				return " User deleted Successfully ";
			}
		}
		
		return " User with Phone No "+ phoneNo + " Not found";
		
	}
	
	
	
}
