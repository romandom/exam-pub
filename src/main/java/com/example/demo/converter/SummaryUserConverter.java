package com.example.demo.converter;

import com.example.demo.domain.dto.SummaryUserDto;
import com.example.demo.domain.entity.OrderEntity;

public class SummaryUserConverter {
    public static SummaryUserDto toDto(OrderEntity orderEntity)
    {
        SummaryUserDto summaryUserDto = new SummaryUserDto();
        summaryUserDto.setProduct(orderEntity.getProduct().getProductName());
        summaryUserDto.setPrice(orderEntity.getUnitPrice());

        return summaryUserDto;
    }
}
