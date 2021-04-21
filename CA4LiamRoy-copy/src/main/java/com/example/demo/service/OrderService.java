package com.example.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CartItem;
import com.example.demo.entities.Order;
import com.example.demo.entities.Stock;
import com.example.demo.entities.User;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.CartDto;
import com.example.demo.web.dto.StockDto;
import com.example.demo.web.dto.UserRegistrationDto;



@Service
public interface OrderService{
	CartItem save(CartDto cartDto);
}

