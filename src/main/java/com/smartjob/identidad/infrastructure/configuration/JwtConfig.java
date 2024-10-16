package com.smartjob.identidad.infrastructure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Validated
@Data
@Component
@ConfigurationProperties(prefix = "token.jwt")
public class JwtConfig {
	@NotBlank(message = "Se requiere configurar el secret para JWT")
	private String secret;
	
	@NotNull(message = "Se requiere configurar el tiempo de expiracion del JWT")
	@Min(value = 60000, message = "la expiracion del JWT debe ser minimo un minuto (60000 milisegundos)")
    private Long expiration;
}
