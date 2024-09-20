package com.example.demo;



public class Student {

	private int Rollno;
	private String nam;
	private int age;
	
	public Student(int rollno, String nam, int age) {
		super();
		Rollno = rollno;
		this.nam = nam;
		this.age = age;
	}

	public int getRollno() {
		return Rollno;
	}

	public void setRollno(int rollno) {
		Rollno = rollno;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [Rollno=" + Rollno + ", name=" + nam + ", age=" + age + "]";
	}
	
	
	
	
}
