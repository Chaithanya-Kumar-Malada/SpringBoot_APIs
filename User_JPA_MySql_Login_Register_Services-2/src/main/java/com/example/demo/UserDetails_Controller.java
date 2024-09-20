package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.EnterAllFields;
import com.example.demo.Exceptions.UserNotFound;
import com.example.demo.Exceptions.User_AlreadyExist;

@RestController
@CrossOrigin
public class UserDetails_Controller {

	
	@Autowired
	Service_UserDetails user_ser;
	
	
	@GetMapping("/users")
	public List<UserDetails> getAllUsers(){
		return user_ser.getallUsers();
	}
	
	
	@GetMapping("/user/{id}")
	public UserDetails getUserbyId(@PathVariable long id) throws UserNotFound{
		
		return user_ser.getUserById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/user/register")
	public String registerUser(@RequestBody UserDetails u1)throws User_AlreadyExist,EnterAllFields {
		return user_ser.registerUser(u1);
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/user/login")
	public String login(@RequestBody UserDetails u1) {
		return user_ser.login(u1);
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/user/update/{id}")
	public String userUpdate(@PathVariable long id, @RequestBody UserDetails u1)
	throws UserNotFound,EnterAllFields,User_AlreadyExist{
		
		return user_ser.userUpdate(id,u1);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PatchMapping("/user/patch/{id}")
	public String userpatchUpdate(@PathVariable long id, @RequestBody UserDetails u1)
	throws UserNotFound,User_AlreadyExist{
		
		return user_ser.userpatchUpdate(id,u1);
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable long id)throws UserNotFound{
		return user_ser.DeleteUserbyId(id);
	}
	
	
}
