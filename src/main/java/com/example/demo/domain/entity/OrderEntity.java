package com.example.demo.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "order")
@Entity
@Data
public class OrderEntity {

	@GeneratedValue
	@Id
	private int id;
	
	private int amount;
	
	@Column(name = "unit_price")
	private float unitPrice;
	
	@Column(name = "total_price")
	private float totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;
	
	
}
