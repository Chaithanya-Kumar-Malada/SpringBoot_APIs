package com.example.demo;

public class ProductResponse {
    private Long id;
    private String name;
    private double price;
    private RatingResponse rating;
    private String imageUrl;  // This will be the URL of the image

    public ProductResponse(Long id, String name, double price, RatingResponse rating, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public RatingResponse getRating() {
        return rating;
    }

    public void setRating(RatingResponse rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

class RatingResponse {
    private double rate;
    private double count;

    public RatingResponse(double rate, double count) {
        this.rate = rate;
        this.count = count;
    }

    // Getters and Setters
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}

