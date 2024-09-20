package com.example.demo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Rating {

	private double rate;
	private double count;
	
	
	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(double rate, double count) {
		super();
		this.rate = rate;
		this.count = count;
	}
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count2) {
		this.count = count2;
	}
}
