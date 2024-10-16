package com.smartjob.identidad.infrastructure.adapter.in.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.smartjob.identidad.domain.model.Phone;
import com.smartjob.identidad.infrastructure.adapter.in.web.dto.PhoneDTO;

@Mapper(componentModel = "spring")
public interface PhoneDtoMapper {

	@Mapping(target = "id", ignore = true)
    Phone toDomain(PhoneDTO dto);

    PhoneDTO toDto(Phone phone);
    
}