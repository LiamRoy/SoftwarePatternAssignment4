package com.example.demo.web.dto;

public class UserRegistrationDto {
	private String email;
	private String username;
	private String password;
	private String address;
	private String payment;
	
	public UserRegistrationDto(){
		
	}

	public UserRegistrationDto(String email, String username, String password, String address, String payment) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.payment = payment;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
}