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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.EnterAllFields;
import com.example.demo.Exceptions.UserAlreadyExist;
import com.example.demo.Exceptions.UserNotFound;

@RestController
@CrossOrigin
public class UserController {

			@Autowired
		private	UserService user_ser;
			
	
	@GetMapping("/users")
		public List<User> getallusers(){
			return user_ser.getallusers();
		}
	
	@GetMapping("/user/{id}")
		public User getuserbyid(@PathVariable long id) throws UserNotFound {
		
		return user_ser.getuserbyid(id);
	}
	
	@PostMapping("/user/register")
		public String saveuser(@RequestBody User u1) throws UserAlreadyExist,EnterAllFields {
		return user_ser.saveuser(u1);
			
	}
	
	
	@PostMapping("/user/login")
	
		public LoginResponse LoginUser(@RequestBody User u1) {
		
		 return user_ser.loginuser(u1.getPhoneno(),u1.getPassword()) ;	
	}
	
	
	
	@PutMapping("/user/update/{id}")
		public String updateUser(@PathVariable long id, @RequestBody User u1) throws UserNotFound,EnterAllFields {
	
		user_ser.updateUser(id,u1);
		return "User updated Succesfully";
	}
	
	@PatchMapping("/user/{id}")
	public String patchupdate(@PathVariable Long id,@RequestBody User u1)throws UserNotFound ,UserAlreadyExist {
	
		return user_ser.patchupdate(id,u1);
	}
	
	
	
	@DeleteMapping("/user/delete/{id}")
		public String deleteUser(@PathVariable long id)throws UserNotFound {
			user_ser.deleteUser(id);
		return "User Deleted Success";	
	}
	
}
