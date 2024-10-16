package com.smartjob.identidad.infrastructure.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjob.identidad.domain.model.User;
import com.smartjob.identidad.domain.port.in.RegisterUserPort;
import com.smartjob.identidad.infrastructure.adapter.in.web.dto.UserRequestDTO;
import com.smartjob.identidad.infrastructure.adapter.in.web.dto.UserResponseDTO;
import com.smartjob.identidad.infrastructure.adapter.in.web.mapper.UserDtoMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Usuarios")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	private final RegisterUserPort registerUserPort;
	private final UserDtoMapper userRequestMapper;

	@Operation(summary = "Registro de usuario", description = "API para el registro de usuarios.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario registrado con exito"),
            @ApiResponse(responseCode = "400", description = "Datos de registro invalidos"),
            @ApiResponse(responseCode = "409", description = "Email ya registrado"),
    })
	@PostMapping
	public ResponseEntity<UserResponseDTO> registerUser(@RequestBody @Validated UserRequestDTO request) {
		User registeredUser = registerUserPort.registerUser(userRequestMapper.toDomain(request));
		return new ResponseEntity<>(userRequestMapper.toResponse(registeredUser), HttpStatus.CREATED);
	}

}
