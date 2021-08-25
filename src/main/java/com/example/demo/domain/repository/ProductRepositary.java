package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entity.ProductEntity;

public interface ProductRepositary extends JpaRepository<ProductEntity, Integer> {

}
