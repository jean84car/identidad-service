package com.smartjob.identidad.domain.port.out;

public interface TokenPort {

	String generateToken(String email);
	
}
