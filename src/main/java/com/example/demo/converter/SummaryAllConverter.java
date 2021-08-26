package com.example.demo.converter;

import com.example.demo.domain.dto.SummaryAllDto;
import com.example.demo.domain.entity.OrderEntity;

public class SummaryAllConverter {

    public static SummaryAllDto toDto(OrderEntity orderEntity) {
        SummaryAllDto summaryAllDto = new SummaryAllDto();
        summaryAllDto.setProduct(orderEntity.getProduct().getProductName());
        summaryAllDto.setAmount(orderEntity.getAmount());
        summaryAllDto.setUnitPrice(orderEntity.getUnitPrice());
        summaryAllDto.setSummaryPrice(orderEntity.getTotalPrice());

        return summaryAllDto;

    }
}
