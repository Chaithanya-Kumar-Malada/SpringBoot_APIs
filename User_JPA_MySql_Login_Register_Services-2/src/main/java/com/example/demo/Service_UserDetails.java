package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.EnterAllFields;
import com.example.demo.Exceptions.UserNotFound;
import com.example.demo.Exceptions.User_AlreadyExist;

@Service
public class Service_UserDetails {
	
	@Autowired
	User_Details_Repository user_repo;
	
	                                               // Get method to get all Users
	public List<UserDetails> getallUsers() {
		return user_repo.findAll();
	}
	
	public UserDetails getUserById(long id)throws UserNotFound {
		
		UserDetails existing = user_repo.findById(id).orElse(null);
			if(existing ==null) {
				throw new UserNotFound("User Not Exist with ID");
			}
		return existing;
	}
												// POST add new User

	public String registerUser(UserDetails u1) throws User_AlreadyExist,EnterAllFields{
		
		if(u1.getName()==null ||u1.getEmail()==null ||u1.getPhoneno()==null||u1.getPassword()==null) {
			
			throw new EnterAllFields("Enter all the Fields Name,phoneno,email,password");
		}
		
		UserDetails existing = user_repo.findByPhoneno(u1.getPhoneno()).orElse(null);
		
		if(existing !=null) {
			
			 throw new User_AlreadyExist("User Already Registered with PhoneNo :"+ u1.getPhoneno() );
		}
		
		user_repo.save(u1);
		
		return "User Registered Successfully";
	}
	
		
	public String login(UserDetails u1) {
		
			UserDetails existing = user_repo.findByPhonenoAndPassword
                           (u1.getPhoneno(),u1.getPassword()).orElse(null);

     if(existing ==null) {
    	 return "Phone number and Password does not match";
     }
		return "User login Successfully";
	}
	
	
														// Delete User By ID
	
	public String DeleteUserbyId(long id) throws UserNotFound{
		
		UserDetails existing = user_repo.findById(id).orElse(null);
			if(existing ==null) {	
				throw new UserNotFound("User Not Exist with ID");
			}
		user_repo.delete(existing);
		return "User Deleted Sucessfully";
		
	}

	public String userUpdate(long id, UserDetails u1)throws UserNotFound ,EnterAllFields,User_AlreadyExist{
		
			UserDetails existing = user_repo.findById(id).orElse(null);
			if(existing==null){
				throw new UserNotFound("User Not Exist with ID");
			}
		
			if(u1.getName()==null ||u1.getEmail()==null ||u1.getPhoneno()==null||u1.getPassword()==null) 
			{			
				throw new EnterAllFields("Enter all the Fields Name,email,password");
			}
		
		UserDetails existingPhoneno = user_repo.findByPhoneno(u1.getPhoneno()).orElse(null);
			
			if(existingPhoneno !=null) {
				 throw new User_AlreadyExist("User Already Registered with PhoneNo :"+ u1.getPhoneno() );
			}
				existing.setName(u1.getName());
				existing.setEmail(u1.getEmail());
				existing.setPhoneno(u1.getPhoneno());
				existing.setPassword(u1.getPassword());
		
		user_repo.save(existing);	
		return "User updated Succesfully";
	}

	
	
	public String userpatchUpdate(long id, UserDetails u1) throws UserNotFound,User_AlreadyExist {
		
		UserDetails existing = user_repo.findById(id).orElse(null);
				if(existing==null){
					throw new UserNotFound("User Not Exist with ID");
				}
		
				UserDetails existingPhoneno = user_repo.findByPhoneno(u1.getPhoneno()).orElse(null);
				
				if(existingPhoneno !=null) {
					 throw new User_AlreadyExist("User Already Registered with PhoneNo :"+ u1.getPhoneno() );
				}
				
			if(u1.getName() !=null) {
				existing.setName(u1.getName());
			}
			if(u1.getEmail() !=null) {
				existing.setEmail(u1.getEmail());
			}
			if(u1.getPassword() !=null) {
				existing.setPassword(u1.getPassword());
			}
			if(u1.getPhoneno() !=null) {
				existing.setPhoneno(u1.getPhoneno());
			}
		
			user_repo.save(existing);
		
		return "User patch Updated";
	}


	
	
	
	
	

}
