package com.example.demo.converter;

import com.example.demo.domain.dto.SummaryProductDto;
import com.example.demo.domain.entity.OrderEntity;

public class SummaryProductConverter {
    public static SummaryProductDto toDto(OrderEntity orderEntity)
    {
        SummaryProductDto summaryProductDto = new SummaryProductDto();
        summaryProductDto.setUserId(orderEntity.getUser().getId());
        summaryProductDto.setAmount(orderEntity.getAmount());
        summaryProductDto.setPrice(orderEntity.getProduct().getPrice());

        return summaryProductDto;
    }
}
