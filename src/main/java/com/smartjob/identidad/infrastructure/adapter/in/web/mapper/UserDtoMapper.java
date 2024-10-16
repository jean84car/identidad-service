package com.smartjob.identidad.infrastructure.adapter.in.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.smartjob.identidad.domain.model.User;
import com.smartjob.identidad.infrastructure.adapter.in.web.dto.UserRequestDTO;
import com.smartjob.identidad.infrastructure.adapter.in.web.dto.UserResponseDTO;

@Mapper(componentModel = "spring", uses = { PhoneDtoMapper.class })
public interface UserDtoMapper {

	@Mapping(target = "created", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "isactive", ignore = true)
	@Mapping(target = "lastLogin", ignore = true)
	@Mapping(target = "modified", ignore = true)
	@Mapping(target = "token", ignore = true)
	User toDomain(UserRequestDTO dto);

	@Mapping(source = "isactive", target = "active")
	UserResponseDTO toResponse(User user);

}
