package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Stock;
import com.example.demo.entities.User;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer>{
	
	Stock findByTitle(String title);
	Stock findById(int id);

}
