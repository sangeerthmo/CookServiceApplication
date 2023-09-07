package com.me.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.me.exception.CookNotFoundException;

@ControllerAdvice
public class CookExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value 
		      = { CookNotFoundException.class })
		    protected ResponseEntity<Object> handleConflict(
		      RuntimeException ex, WebRequest request) {
		        String bodyOfResponse = "Cook with this cookid not found";
		        return handleExceptionInternal(ex, bodyOfResponse, 
		          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		    }
	
			/*
			 * @ResponseStatus(HttpStatus.BAD_REQUEST)
			 * 
			 * @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String,
			 * String> handleValidationExceptions( MethodArgumentNotValidException ex) {
			 * Map<String, String> errors = new HashMap<>();
			 * ex.getBindingResult().getAllErrors().forEach(error -> { String fieldName =
			 * ((FieldError) error).getField(); String errorMessage =
			 * error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); return
			 * errors; }
			 */
}