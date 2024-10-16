package com.smartjob.identidad.domain.exception;

public class EmailAlreadyRegisteredException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1848828271653678121L;

	public EmailAlreadyRegisteredException(String message) {
        super(message);
    }
    
}