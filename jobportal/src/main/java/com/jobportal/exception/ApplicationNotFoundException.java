package com.jobportal.exception;

public class ApplicationNotFoundException extends RuntimeException {
	
	public ApplicationNotFoundException(String message) {
        super(message);
    }

}
