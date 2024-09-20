package com.example.demo.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException_Handler {

	
	@ExceptionHandler(User_AlreadyExist.class)
	@ResponseStatus(HttpStatus.FOUND)
	public Map<String,String> GlobalUserAlreadyExist(User_AlreadyExist u1){
	
		Map<String,String> Errormsg = new HashMap<>();
		
			Errormsg.put("Error", u1.getMessage());
		return Errormsg;
	}
	
	
	@ExceptionHandler(EnterAllFields.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,String> GlobalEnterAllFields(EnterAllFields enterAll){
		
		Map<String,String> Errormsg = new HashMap<>();
		
		Errormsg.put("Error", enterAll.getMessage());
	return Errormsg;
		
	}
	
	@ExceptionHandler(ProductNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,String> GlobalUserNotFound(ProductNotFound notfound){
		
		Map<String,String> Errormsg = new HashMap<>();
		
		Errormsg.put("Error", notfound.getMessage());
	return Errormsg;
		
	}
	
	
	
	
	
	
	
	
	
}
