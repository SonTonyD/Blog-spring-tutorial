package com.formation.blog.exceptions;

public class UserAlreadyExistException extends Exception {
	
private static final long serialVersionUID = -5211375367149169313L;
private String message;
	
	public UserAlreadyExistException(String message) {
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
