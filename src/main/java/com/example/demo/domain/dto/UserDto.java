package com.example.demo.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

	private int id;

	private String name;

	private boolean isActive;

	private boolean isAdult;

	private float pocket;

	private List<OrderDto> orders;
	
}
