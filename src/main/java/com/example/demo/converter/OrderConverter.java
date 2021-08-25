package com.example.demo.converter;

import com.example.demo.domain.dto.OrderDto;
import com.example.demo.domain.entity.OrderEntity;
import org.aspectj.weaver.ast.Or;

import java.util.stream.Collectors;

public class OrderConverter {
	
	public static OrderDto toDto(OrderEntity orderEntity)
	{
		OrderDto orderDto = new OrderDto();
		orderDto.setId(orderEntity.getId());
		orderDto.setProductName(orderEntity.getProduct().getProductName());
		orderDto.setAmount(orderEntity.getAmount());
		orderDto.setPrice(orderEntity.getProduct().getPrice());

		return orderDto;
	}

}
