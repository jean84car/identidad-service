package com.smartjob.identidad.infrastructure.adapter.in.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.smartjob.identidad.domain.exception.EmailAlreadyRegisteredException;
import com.smartjob.identidad.domain.exception.EmailInvalidFormatException;
import com.smartjob.identidad.domain.exception.PasswordInvalidFormatException;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {
	
	private static final String FIELD_RESPONSE = "mensaje";

	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		log.error("Error en la solicitud", ex);
        return new ResponseEntity<>(getError("La solicitud no es correcta, revisar los datos requeridos"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleConstraintViolationExceptions(ConstraintViolationException ex) {
    	log.error("Error al egistrar en la base de datos", ex);
        return new ResponseEntity<>(getError("No es posible realizar el registro"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyRegisteredException(EmailAlreadyRegisteredException ex) {
    	log.error("El email ya esta registrado", ex);
        return new ResponseEntity<>(getError(ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmailInvalidFormatException.class)
    public ResponseEntity<Map<String, String>> handleEmailInvalidFormatException(EmailInvalidFormatException ex) {
    	log.error("Formato de email invalido", ex);
        return new ResponseEntity<>(getError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordInvalidFormatException.class)
    public ResponseEntity<Map<String, String>> handlePasswordInvalidFormatException(PasswordInvalidFormatException ex) {
    	log.error("Formato de clave invalido", ex);
        return new ResponseEntity<>(getError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAllUncaughtException(Exception ex) {
    	log.error("Error", ex);
        return new ResponseEntity<>(getError("No es posible realizar la operacion, intente mas tarde"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private Map<String, String> getError(String mensaje) {
    	Map<String, String> errors = new HashMap<>();
        errors.put(FIELD_RESPONSE, mensaje);
        
        return errors;
    }
	
}
