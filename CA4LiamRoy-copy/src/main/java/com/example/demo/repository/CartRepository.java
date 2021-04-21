package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.CartItem;
import com.example.demo.entities.Order;
import com.example.demo.web.dto.CartDto;

public interface CartRepository extends CrudRepository<CartItem, Integer>{

	CartItem save(CartDto CartDto);
}
