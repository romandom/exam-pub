package com.example.demo.converter;

import com.example.demo.domain.dto.OrderDto;
import com.example.demo.domain.entity.OrderEntity;
import com.example.demo.domain.entity.ProductEntity;

public class ProductConverter {
    public static OrderDto toDto(ProductEntity productEntity)
    {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(productEntity.getId());
        orderDto.setProductName(productEntity.getProductName());
        orderDto.setPrice(productEntity.getPrice());
        orderDto.setForAdult(productEntity.isForAdult());

        return orderDto;
    }

}
