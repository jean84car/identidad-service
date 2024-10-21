package com.smartjob.identidad.infrastructure.adapter.in.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.smartjob.identidad.domain.model.User;
import com.smartjob.identidad.domain.port.in.RegisterUserPort;
import com.smartjob.identidad.infrastructure.adapter.in.web.dto.UserRequestDTO;
import com.smartjob.identidad.infrastructure.adapter.in.web.dto.UserResponseDTO;
import com.smartjob.identidad.infrastructure.adapter.in.web.mapper.UserDtoMapper;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private RegisterUserPort registerUserPort;

    @Mock
    private UserDtoMapper userDtoMapper;

    @InjectMocks
    private UserController userController;

    @Test
    void registerUserTest() {
        UserRequestDTO request = new UserRequestDTO();
        request.setEmail("jean@smartjob.com");
        request.setPassword("Clave123");

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        when(userDtoMapper.toDomain(request)).thenReturn(user);
        when(registerUserPort.registerUser(any(User.class))).thenReturn(user);
        when(userDtoMapper.toResponse(user)).thenReturn(UserResponseDTO.builder().email(user.getEmail()).build());

        ResponseEntity<UserResponseDTO> response = userController.registerUser(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(request.getEmail(), response.getBody().getEmail());
    }
}
