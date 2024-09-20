package com.example.demo.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,String> handleStudentNotFound( StudentNotFound stderror ){
		
		Map<String,String> errormap = new HashMap<>();
		
			errormap.put("Error message:", stderror.getMessage() );
		
		return errormap;
	}

}
