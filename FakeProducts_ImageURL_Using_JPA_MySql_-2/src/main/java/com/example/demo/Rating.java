package com.example.demo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Rating {

	private Double rate;
	private Double count;
	
	
	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rating(Double rate, Double count) {
		super();
		this.rate = rate;
		this.count = count;
	}
	
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getCount() {
		return count;
	}
	public void setCount(Double count2) {
		this.count = count2;
	}
}
