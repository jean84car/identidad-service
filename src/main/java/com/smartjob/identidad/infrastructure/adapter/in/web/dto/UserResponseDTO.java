package com.smartjob.identidad.infrastructure.adapter.in.web.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class UserResponseDTO {
	
	private String id;
    private String name;
    private String email;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean active;
    private List<PhoneDTO> phones;
    
}
