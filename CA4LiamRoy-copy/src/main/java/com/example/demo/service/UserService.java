package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entities.User;
import com.example.demo.web.dto.UserRegistrationDto;

//Strategy Pattern
public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
	public User findByUsernameAndPassword(String username, String password);
    	public User findByUsername(String username);
  
	
}
