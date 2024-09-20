package com.example.demo;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {
	
    private String name;
    private Double price;
    private Double ratingRate;
    private Double ratingCount;
    private MultipartFile image;  // MultipartFile for image upload
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getRatingRate() {
		return ratingRate;
	}
	public void setRatingRate(Double ratingRate) {
		this.ratingRate = ratingRate;
	}
	public Double getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(Double ratingCount) {
		this.ratingCount = ratingCount;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
    
    

    
    
}
