package com.smartjob.identidad.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smartjob.identidad.domain.port.out.UserRepositoryPort;
import com.smartjob.identidad.domain.service.UserService;

@Configuration
public class UserServiceConfig {

	@Bean
	public UserService userService(UserRepositoryPort userRepositoryPort, UserValidatorConfig userValidatorConfig) {
		return new UserService(userRepositoryPort, userValidatorConfig);
	}

}
