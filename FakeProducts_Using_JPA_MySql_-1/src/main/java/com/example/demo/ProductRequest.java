package com.example.demo;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {
    private String name;
    private double price;
    private double ratingRate;  // Use separate fields for rating components
    private double ratingCount;
    private MultipartFile image;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRatingRate() {
		return ratingRate;
	}
	public void setRatingRate(double ratingRate) {
		this.ratingRate = ratingRate;
	}
	public double getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(double ratingCount) {
		this.ratingCount = ratingCount;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}

    // Getters and Setters
    
    
    
}
