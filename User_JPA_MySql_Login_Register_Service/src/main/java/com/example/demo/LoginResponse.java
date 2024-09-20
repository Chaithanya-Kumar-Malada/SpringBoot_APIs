package com.example.demo;



public class LoginResponse {
    private String message;
    private String name;
    private String phoneNo;
    private String email;

    // Constructors
    public LoginResponse(String message) {
        this.message = message;
    }

    public LoginResponse(String message, String name, String phoneNo, String email) {
        this.message = message;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}