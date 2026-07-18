package com.Demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>>  resourceNotFoundHandler(ResourceNotFoundException rnfe){
	 Map<String, Object> map = new HashMap<String, Object>();
	 map.put("message", rnfe.getMessage());
	 map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
	 map.put("timestamp", LocalDateTime.now());
	 
	 return new ResponseEntity<Map<String,Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
