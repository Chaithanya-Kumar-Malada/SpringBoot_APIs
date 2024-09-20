package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.EnterAllFields;
import com.example.demo.Exceptions.UserAlreadyExist;
import com.example.demo.Exceptions.UserNotFound;

@Service
public class UserService {

	@Autowired
private	UserRepository user_repo;
	
		public List<User> getallusers(){
			return user_repo.findAll();
		}

		public User getuserbyid(long id) throws UserNotFound {
			
			User existing = user_repo.findById(id).orElse(null);
				if(existing ==null) {
					throw new UserNotFound("User with Id - "+ id +" Not Found");
				}
			return existing;
		}
		
		
		public String saveuser(User u1) throws UserAlreadyExist,EnterAllFields{
			
			User existing = user_repo.findByPhoneno(u1.getPhoneno()).orElse(null);
			
			if(existing !=null ) {
				throw new UserAlreadyExist("User Already Exists with PhoneNo -"+u1.getPhoneno()+ " Try with another PhoneNo");
			}
			
			String ids = String.valueOf(u1.getId());
			
			if(u1.getName()==null || u1.getPhoneno()==null || u1.getEmail()==null|| u1.getPassword()==null) {
				
				throw new EnterAllFields("Enter All the Fields name, phoneNo,Email,Password");
			}
			user_repo.save(u1);
			return "User Register Successfully";
		}
		
//		public String Loginuser(String phoneno, String password)  {
//		
//			 if(user_repo.existByPhoneno(phoneno ) ) {
//			    	
//			    	if(user_repo.existsByPassword(password )) {
//			    		return "User Login Successfully";
//			    	}
//			    	return "Incorrect password";
//			    }
//			
//			 return "User does not exist with PhoneNo " + phoneno ;
//
//			
//		}
		
		public LoginResponse loginuser(String phoneno,String password) {
			
			
			Optional<User> findphoneno = user_repo.findByPhoneno(phoneno);
			Optional<User> user = user_repo.findByPhonenoAndPassword(phoneno, password);
			
			
			//return user.isPresent() ? "User Login Successfully" : "Incorrect phoneNo or password ";
		if(findphoneno.isPresent())	{
			
			if(user.isPresent()) {
				
				User u1 = user.get();
				
				return new LoginResponse("Login Sucessfully!",u1.getName(),u1.getPhoneno(),u1.getEmail());
			}else {
				return new LoginResponse("Incorrect phoneNo or password ");
			}
		}
		return new LoginResponse("PhoneNo does not exist");
		
		}
		
	

		public void updateUser(long id,User u1)throws UserNotFound,EnterAllFields  {
			
			User existing = user_repo.findById(id).orElse(null);
			
			if(existing ==null) {
				throw new UserNotFound("User with Id - "+ id +" Not Found");
			}
			
			if(u1.getName()==null || u1.getPhoneno()==null || u1.getEmail()==null|| u1.getPassword()==null) {
				
				throw new EnterAllFields("Enter All the Fields name, phoneNo,Email,Password");
			}
			
			
			if(existing != null) {
				
				existing.setId(u1.getId());
				existing.setName(u1.getName());
				existing.setPhoneno(u1.getPhoneno());
				existing.setEmail(u1.getEmail());
				existing.setPassword(u1.getPassword());
				
				user_repo.save(existing);
			}
		}
		
			public String patchupdate(Long id, User u1) throws UserNotFound,UserAlreadyExist {
		
				User existing = user_repo.findById(id).orElse(null);
				
				Optional<User> findPhono = user_repo.findByPhoneno(u1.getPhoneno());
				
				if(existing ==null) {
					throw new UserNotFound("User with Id - "+ id +" Not Found");
				}
				
				if(findPhono.isPresent()) {
					
						throw new UserAlreadyExist("User Already Exists with PhoneNo -"+u1.getPhoneno()+ " Try with another PhoneNo");
					
				}
				
				
				if(u1.getName() !=null) {
					existing.setName(u1.getName());
				}
				if(u1.getPhoneno() !=null) {
					existing.setPhoneno(u1.getPhoneno());
				}
				if(u1.getEmail()!=null) {
					existing.setEmail(u1.getEmail());
				}
				if(u1.getPassword()!=null) {
					existing.setPassword(u1.getPassword());
				}
				
			user_repo.save(existing);
				
			return "User Updated Successfully!";
		}
		
		public void deleteUser(long id) throws UserNotFound {
			
			User existing = user_repo.findById(id).orElse(null);
			if(existing ==null) {
				throw new UserNotFound("User with Id - "+ id +" Not Found");
			}
			
			user_repo.deleteById(id);
		}

		

		

		
	
	
	
	
	
}
