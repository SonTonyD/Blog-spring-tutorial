package com.formation.blog.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {EntityNotFoundException.class})
	protected ResponseEntity<Object> handleEntityNotFoundException(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "EntityNotFoundException: "+ex.getMessage();
		return new ResponseEntity<> (bodyOfResponse ,new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler(value = {UserAlreadyExistException.class})
	protected ResponseEntity<Object> handleUserAlreadyExistException(Exception ex, WebRequest request) {
		String bodyOfResponse = "UserAlreadyExistException: "+ex.getMessage();
		return new ResponseEntity<> (bodyOfResponse ,new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = {EmptyResultDataAccessException.class})
	protected ResponseEntity<Object> handleUserAlreadyExidstException(Exception ex, WebRequest request) {
		String bodyOfResponse = "UserAlreadyExistException: "+ex.getMessage();
		return new ResponseEntity<> (bodyOfResponse ,new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}
}
