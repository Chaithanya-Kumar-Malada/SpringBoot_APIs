package com.example.demo.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
		@ExceptionHandler(UserNotFound.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,String> GlobalExceptionHandlerUserNotFound(UserNotFound n1) {
		
		Map<String,String> errormap = new HashMap<>();
			errormap.put("Error message", n1.getMessage());
			
		 return errormap;
	}
	
		@ExceptionHandler(UserAlreadyExist.class)
		@ResponseStatus(HttpStatus.FOUND)
	public Map<String,String> GlobalExceptionHandlerUserAlreadyExist(UserAlreadyExist e1) {
		
		Map<String,String> errormap = new HashMap<>();
			errormap.put("Error message", e1.getMessage());
			
		 return errormap;
	}
	
		@ExceptionHandler(EnterAllFields.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,String> GlobalExceptionHandlerEnterAllFields(EnterAllFields f1) {
		
		Map<String,String> errormap = new HashMap<>();
			errormap.put("Error message", f1.getMessage());
			
		 return errormap;
	}
	
	

}
