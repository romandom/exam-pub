package com.example.demo.domain.dto;

import lombok.Data;

@Data
public class BuyDto {

    private int userId;

    private int productId;

    private float price;
}
