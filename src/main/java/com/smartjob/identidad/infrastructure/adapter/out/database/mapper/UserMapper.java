package com.smartjob.identidad.infrastructure.adapter.out.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.smartjob.identidad.domain.model.User;
import com.smartjob.identidad.infrastructure.adapter.out.database.entity.UserEntity;

@Mapper(componentModel = "spring", uses = { PhoneMapper.class })
public interface UserMapper {

    @Mapping(source = "lastLogin", target = "lastLogin", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    User toDomain(UserEntity userEntity);

    @Mapping(source = "lastLogin", target = "lastLogin", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    UserEntity toEntity(User user);
    
}
