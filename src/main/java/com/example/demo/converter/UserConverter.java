package com.example.demo.converter;

import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.entity.UserEntity;

import java.util.stream.Collectors;

public class UserConverter {

    public static UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setActive(entity.isActive());
        dto.setAdult(entity.isAdult());
        dto.setPocket(entity.getPocket());

        dto.setOrders(entity.getOrders().stream().map(OrderConverter::toDto).collect(Collectors.toList()));

        return dto;
    }
}
