package com.example.demo.web.dto;

import com.example.demo.entities.Stock;

public class CartDto {
	
	private String item;
    private int quantity;
    
    public CartDto() {
    	
    }

	public CartDto(String item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    

}
