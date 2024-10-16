package com.smartjob.identidad.infrastructure.adapter.out.database;

import org.springframework.stereotype.Component;

import com.smartjob.identidad.domain.model.User;
import com.smartjob.identidad.domain.port.out.UserRepositoryPort;
import com.smartjob.identidad.infrastructure.adapter.out.database.mapper.UserMapper;
import com.smartjob.identidad.infrastructure.adapter.out.database.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserRepositoryAdapter implements UserRepositoryPort {
	
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        return userMapper.toDomain(userJpaRepository.save(userMapper.toEntity(user)));
    }

	@Override
	public boolean existsByEmail(String email) {
		return userJpaRepository.existsByEmail(email);
	}
}
