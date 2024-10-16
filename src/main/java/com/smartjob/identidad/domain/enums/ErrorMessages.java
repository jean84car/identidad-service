package com.smartjob.identidad.domain.enums;

public enum ErrorMessages {

	EMAIL_ALREADY_REGISTERED("El correo ya registrado"),
	PASSWORD_INVALID_FORMAT("El formato de la clave es incorrecto"),
    EMAIL_INVALID_FORMA("El formato del correo es incorrecto");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
	
}
