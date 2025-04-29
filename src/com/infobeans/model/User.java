package com.infobeans.model;

public class User {
    private int id;
    private String username;
    private String password;  
    private String email;
    private String role;
    private String department;

    public User(int id, String username, String password ,String email, String role, String department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email=email;
        this.role = role;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { 
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getEmail() { 
    	return email;
    }
    
    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }
}


