package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {
}
