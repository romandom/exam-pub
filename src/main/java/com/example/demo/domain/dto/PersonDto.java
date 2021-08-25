package com.example.demo.domain.dto;

import lombok.Data;

@Data
public class PersonDto {
    private int id;

    private String name;

    private boolean isActive;

    private boolean isAdult;

    private float pocket;
}
