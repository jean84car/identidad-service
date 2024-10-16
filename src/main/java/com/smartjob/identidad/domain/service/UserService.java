package com.smartjob.identidad.domain.service;

import com.smartjob.identidad.domain.enums.ErrorMessages;
import com.smartjob.identidad.domain.exception.EmailAlreadyRegisteredException;
import com.smartjob.identidad.domain.exception.EmailInvalidFormatException;
import com.smartjob.identidad.domain.exception.PasswordInvalidFormatException;
import com.smartjob.identidad.domain.model.User;
import com.smartjob.identidad.domain.port.out.UserRepositoryPort;
import com.smartjob.identidad.infrastructure.configuration.UserValidatorConfig;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

	private final UserRepositoryPort userRepositoryPort;
	private final UserValidatorConfig userValidatorConfig;

    public void validateExisteEmail(String email) {
        if (userRepositoryPort.existsByEmail(email)) {
            throw new EmailAlreadyRegisteredException(ErrorMessages.EMAIL_ALREADY_REGISTERED.getMessage());
        }
    }
    
    public void validateFormatEmail(String email) {
    	if(email == null || !email.matches(userValidatorConfig.getEmailRegex())) {
    		throw new EmailInvalidFormatException(ErrorMessages.EMAIL_INVALID_FORMA.getMessage());
    	}
    }
    
    public void validateFormatPassword(String password) {    	
        if(password == null || !password.matches(userValidatorConfig.getPasswordRegex())) {
        	throw new PasswordInvalidFormatException(ErrorMessages.PASSWORD_INVALID_FORMAT.getMessage());
        }
    }
	
    public void validateUserRegister(User user) {
    	validateFormatEmail(user.getEmail());
    	validateExisteEmail(user.getEmail());
    	validateFormatPassword(user.getPassword());
    }
    
}
