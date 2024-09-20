package com.example.demo;

public class Employee {

	private int id;
	private String name;
	private int ages;
	private double salary;
	
	public Employee(int id, String name, int ages, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.ages = ages;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAges() {
		return ages;
	}

	public void setAge(int ages) {
		this.ages = ages;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + ages + ", salary=" + salary + "]";
	}
	
	
	
	
}
