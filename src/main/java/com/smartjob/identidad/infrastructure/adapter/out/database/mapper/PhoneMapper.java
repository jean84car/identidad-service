package com.smartjob.identidad.infrastructure.adapter.out.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.smartjob.identidad.domain.model.Phone;
import com.smartjob.identidad.infrastructure.adapter.out.database.entity.PhoneEntity;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    @Mapping(source = "cityCode", target = "citycode")
    @Mapping(source = "countryCode", target = "contrycode")
    Phone toDomain(PhoneEntity phoneEntity);

    @Mapping(source = "citycode", target = "cityCode")
    @Mapping(source = "contrycode", target = "countryCode")
    PhoneEntity toEntity(Phone phone);
    
}