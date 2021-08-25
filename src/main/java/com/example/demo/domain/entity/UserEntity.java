package com.example.demo.domain.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue
	public int id;
	
	public String name;
	
	@Column(name = "is_active")
	public boolean isActive;
	
	@Column(name = "is_adult")
	public boolean isAdult;
	
	public float pocket;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderEntity> orders;

}
