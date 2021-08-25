package com.example.demo.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {
	
	@Id
	@GeneratedValue
	public int id;
	
	@Column(name = "product_name")
	public String productName;
	
	@Column(name = "is_for_adult")
	public boolean isForAdult;
	
	public float price;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<OrderEntity> orders; 

}
