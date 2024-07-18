package com.cts.user.exceptions;

public class AlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AlreadyExistsException() {
		super("Already Exists");
	}
	
	public AlreadyExistsException(String message) {
		super(message);
	}

}
