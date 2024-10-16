package com.smartjob.identidad.domain.exception;

public class EmailInvalidFormatException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1848828271653678121L;

	public EmailInvalidFormatException(String message) {
        super(message);
    }
    
}