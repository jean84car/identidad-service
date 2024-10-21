package com.smartjob.identidad.domain.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.smartjob.identidad.domain.exception.EmailAlreadyRegisteredException;
import com.smartjob.identidad.domain.exception.EmailInvalidFormatException;
import com.smartjob.identidad.domain.exception.PasswordInvalidFormatException;
import com.smartjob.identidad.domain.port.out.UserRepositoryPort;
import com.smartjob.identidad.infrastructure.configuration.UserValidatorConfig;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepositoryPort userRepositoryPort;

    @Mock
    private UserValidatorConfig userValidatorConfig;

    @InjectMocks
    private UserService userService;

    @Test
    void validateExisteEmailTest() {
        String email = "jean@smartjob.com";
        when(userRepositoryPort.existsByEmail(email)).thenReturn(true);

        assertThrows(EmailAlreadyRegisteredException.class, () -> {
            userService.validateExisteEmail(email);
        });
    }

    @Test
    void validateFormatEmailTest() {
        String email = "jeansmartjob.com";
        when(userValidatorConfig.getEmailRegex()).thenReturn("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");

        assertThrows(EmailInvalidFormatException.class, () -> {
            userService.validateFormatEmail(email);
        });
    }

    @Test
    void validateFormatPasswordTest() {
        String password = "clave";
        when(userValidatorConfig.getPasswordRegex()).thenReturn("^(?=.*[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]{6,}$");

        assertThrows(PasswordInvalidFormatException.class, () -> {
            userService.validateFormatPassword(password);
        });
    }
}