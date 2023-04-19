package com.formation.blog.exceptions;

public class EntityNotFoundException extends RuntimeException{

	private String message;
	
	public EntityNotFoundException(String message) {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
