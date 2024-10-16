package com.smartjob.identidad.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartjob.identidad.domain.model.User;
import com.smartjob.identidad.domain.port.in.RegisterUserPort;
import com.smartjob.identidad.domain.port.out.TokenPort;
import com.smartjob.identidad.domain.port.out.UserRepositoryPort;
import com.smartjob.identidad.domain.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegisterUserUseCase implements RegisterUserPort {

	private final UserService userService;
	private final UserRepositoryPort userPort;
	private final TokenPort tokenPort;
	
	@Override
	@Transactional
	public User registerUser(User user) {
		log.info("Registro de usuario {}", user.getEmail());
		userService.validateUserRegister(user);
		user.setToken(tokenPort.generateToken(user.getEmail()));
		LocalDateTime now = LocalDateTime.now();
		user.setCreated(now);
		user.setLastLogin(now);
		user.setIsactive(true);
		return userPort.save(user);
	}

}
