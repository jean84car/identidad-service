package com.smartjob.identidad.domain.port.in;

import com.smartjob.identidad.domain.model.User;

public interface RegisterUserPort {

	User registerUser(User user);
	
}
