package com.Aadi.execption;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApp {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> exceptionhandler(Exception e) {
		return new  ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String,String>> methodargumentparameterexception(MethodArgumentNotValidException e) {
		
		HashMap<String, String> errors = new HashMap<>();
		
		e.getBindingResult().getFieldErrors().forEach(error->{
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<HashMap<String,String>>(errors,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
