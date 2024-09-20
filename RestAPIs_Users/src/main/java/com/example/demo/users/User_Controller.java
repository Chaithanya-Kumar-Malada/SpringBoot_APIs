package com.example.demo.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class User_Controller {
	
	
 	Map<String,Users> Lists = new HashMap<>();
 	
 	Set<Map.Entry<String,Users>> objset = Lists.entrySet();
	
	@GetMapping
	public Map<String,Users> getUser() {
		
		return Lists;
	}
	
	@GetMapping(path="/{id}")
	public String  getuserById( @PathVariable String id) {
		
	
		if(Lists.containsKey(id)) {
			
			List<Map.Entry<String, Users>> u1 =  objset.stream().filter(i->i.getKey().equals(id)).collect(Collectors.toList());
			return  u1+ " ";
		}	
		
		return "User id is Invalid";
	}
	

	@PostMapping(path ="/add")
	public String addUser(@RequestBody Users u1) {
			
//			for(Map.Entry<String,Users> e:Lists.entrySet() ) {
//				if( e.getKey().equals(u1.getId()) ) {
//					return "User already exit with id ";	
//				}
//			}
		
		//				OR 
		
		if( Lists.containsKey(u1.getId()) ) {
			return "User already exit with id ";	
		}
		
//			Users obj = new Users();
//			obj.setId(u1.getId());
//			obj.setName(u1.getName());
//			obj.setEmail(u1.getEmail());
													//int ids = Integer.parseInt(u1.getId()); 
			Lists.put(u1.getId(), u1);
		return "User added Successfully";
	}
	

	@DeleteMapping(path ="/{id}")
	public String deleteUser(@PathVariable String id) {
		
		if(Lists.containsKey(id)) {
			
				Lists.remove(id);
			return "User deleted Successfully";
		}else {
			return "User not Found with ID. Check the user Id and try again ";
		}
	}
	
	
	@PutMapping(path="/{id}")
	public String editUser(@PathVariable String id, @RequestBody Users u1) {
		
		Users obj = new Users();
		
		if(Lists.containsKey(id)) {
			
			obj.setId(u1.getId());
			obj.setName(u1.getName());
			obj.setEmail(u1.getEmail());
			
			Lists.put(id, obj);
			return "User edited Sucessfully.";
			
		}else {
			return "User not found with Id. check the user id correctly and try Again.";
		}
	}
	
}
