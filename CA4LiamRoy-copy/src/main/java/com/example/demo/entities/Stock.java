package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String manufacturer;
	private double price;
	private String category;
	private String productImageLink;
	private int quantity;
	
	//@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	//private Set<Review> productReviews;
	
//	@OneToOne
//	StockItem StockItem;
	@ManyToMany
    private Set<Order> orders = new HashSet<>();

    @ManyToOne
    private Rating rating;

    @ManyToOne
    private Comment comment;


    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
	
	
	//Constructors
	public Stock() {
		super();
	}
	
	public Stock(String title, String manufacturer, double price, String category, String productImageLink,
			int quantity) {
		super();
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.productImageLink = productImageLink;
		this.quantity = quantity;
	}
	//Utility Methods for adding + removing reviews. synchronizes both sides
    /*public void addReview(Review review) {
    	productReviews.add(review);
    	review.setProduct(this);
    }
    

	public void removeReview(Review review) {
       productReviews.remove(review);
       review.setProduct(null);
    }*/
		
	
	//Getters + Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	/*public Set<Review> getProductReviews() {
		return productReviews;
	}
	public void setProductReviews(Set<Review> productReviews) {
		this.productReviews = productReviews;
	}*/

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", manufacturer=" + manufacturer + ", price=" + price
				+ ", category=" + category + ", productImageLink=" + productImageLink + ", productReviews="
				 /*productReviews + "]"*/;
	}
	
	
	
}
