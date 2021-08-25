package com.example.demo.domain.repository;

import com.example.demo.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositary extends JpaRepository<OrderEntity, Integer> {
}
