package com.formation.blog.exceptions;

public class EntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -7755169645560251882L;
	private String message;
	
	public EntityNotFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
