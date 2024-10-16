package com.smartjob.identidad.domain.exception;

public class PasswordInvalidFormatException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1848828271653678121L;

	public PasswordInvalidFormatException(String message) {
        super(message);
    }
    
}