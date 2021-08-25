package com.example.demo.domain.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class OrderDto {
	
	private int id;
	
	private String productName;
	
	private int amount;

	private boolean isForAdult;
	
	private float price;
	
}
