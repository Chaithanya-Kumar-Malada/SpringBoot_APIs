package com.example.demo;

import java.util.List;

public class Student {

	private int rollno;
	private String name;
	private double marks;
	private int age;
	
	public Student(int rollno, String name, double marks, int age) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
		this.age = age;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	
	
}
