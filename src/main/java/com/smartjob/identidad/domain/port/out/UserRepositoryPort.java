package com.smartjob.identidad.domain.port.out;

import com.smartjob.identidad.domain.model.User;

public interface UserRepositoryPort {
	
	boolean existsByEmail(String email);
    User save(User user);

}
