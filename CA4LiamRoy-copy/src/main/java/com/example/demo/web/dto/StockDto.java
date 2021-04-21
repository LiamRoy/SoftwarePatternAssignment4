package com.example.demo.web.dto;

public class StockDto {

	private String title;
	private String manufacturer;
	private double price;
	private String category;
	private String productImageLink;
	private int quantity;
	
	public StockDto() {
		
	}

	public StockDto(String title, String manufacturer, double price, String category, String productImageLink,
			int quantity) {
		super();
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.productImageLink = productImageLink;
		this.quantity = quantity;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductImageLink() {
		return productImageLink;
	}

	public void setProductImageLink(String productImageLink) {
		this.productImageLink = productImageLink;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
