package com.example.demo.converter;

import com.example.demo.domain.dto.PersonDto;
import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.entity.UserEntity;

public class PersonConvertor {
    public static PersonDto toDto(UserEntity entity) {
        PersonDto dto = new PersonDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setActive(entity.isActive());
        dto.setAdult(entity.isAdult());
        dto.setPocket(entity.getPocket());

        return dto;
    }
}
