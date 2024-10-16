package com.smartjob.identidad.infrastructure.adapter.in.web.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {
	
    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "El email es requerido")
    private String email;

    @NotBlank(message = "La clave es requerida")
    private String password;

    @NotNull(message = "Debe registrar al menos un numero de telefono")
    @Size(min = 1, message = "Debe registrar al menos un numero de telefono")
    private List<PhoneDTO> phones;
}
