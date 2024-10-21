package com.smartjob.identidad.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.smartjob.identidad.domain.model.User;
import com.smartjob.identidad.domain.port.out.TokenPort;
import com.smartjob.identidad.domain.port.out.UserRepositoryPort;
import com.smartjob.identidad.domain.service.UserService;

@ExtendWith(MockitoExtension.class)
class RegisterUserUseCaseTest {

    @Mock
    private UserService userService;

    @Mock
    private UserRepositoryPort userPort;

    @Mock
    private TokenPort tokenPort;

    @InjectMocks
    private RegisterUserUseCase registerUserUseCase;

    @Test
    void registerUserTest() {
        User user = new User();
        String emailRegister = "jean@smartjob.com";
        user.setEmail(emailRegister);
        user.setPassword("Clave123");

        when(tokenPort.generateToken(user.getEmail())).thenReturn("pru3b@-token");
        when(userPort.save(any(User.class))).thenReturn(user);

        User registeredUser = registerUserUseCase.registerUser(user);

        assertNotNull(registeredUser.getToken());
        assertEquals(emailRegister, registeredUser.getEmail());
        assertTrue(registeredUser.isIsactive());
    }
}
