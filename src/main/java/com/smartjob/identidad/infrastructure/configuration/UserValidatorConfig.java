package com.smartjob.identidad.infrastructure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Validated
@Data
@Component
@ConfigurationProperties(prefix = "validation.user")
public class UserValidatorConfig {
	@NotBlank(message = "Se requiere configurar la expresion regular para validar el email")
	private String emailRegex;
	@NotBlank(message = "Se requiere configurar la expresion regular para validar la clave")
    private String passwordRegex;
}
