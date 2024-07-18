package com.cts.user.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resource not found on the server");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
