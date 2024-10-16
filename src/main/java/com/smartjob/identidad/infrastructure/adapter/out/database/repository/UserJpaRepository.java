package com.smartjob.identidad.infrastructure.adapter.out.database.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjob.identidad.infrastructure.adapter.out.database.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    
	boolean existsByEmail(String email);
	
}