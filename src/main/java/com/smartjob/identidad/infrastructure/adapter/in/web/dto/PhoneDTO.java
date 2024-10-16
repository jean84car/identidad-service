package com.smartjob.identidad.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PhoneDTO {
	
	@NotBlank(message = "El numero de telefono es requerido")
    private String number;

    @NotBlank(message = "El codigo de la ciudad es requerida")
    private String citycode;

    @NotBlank(message = "El codigo del pais es requerido")
    private String contrycode;
    
}
