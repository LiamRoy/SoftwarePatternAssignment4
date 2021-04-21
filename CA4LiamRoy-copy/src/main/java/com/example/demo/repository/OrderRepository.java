package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.CartItem;
import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.web.dto.CartDto;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>
{
    Order findById(int id);
    List<Order> findByStatusAndUser(String status, User user);
    List<Order> findByUser(User user);
}
