package com.example.demo.resource;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.converter.ProductConverter;
import com.example.demo.domain.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.repository.ProductRepositary;

@RestController
@RequestMapping("/drinkmenu")
public class ProductResource {

	@Autowired
	private ProductRepositary productRepositary;
	
	@GetMapping
	public List<OrderDto> getAllMenus()
	{

		return productRepositary.findAll().stream().map(ProductConverter::toDto).collect(Collectors.toList());
	}
	
}
