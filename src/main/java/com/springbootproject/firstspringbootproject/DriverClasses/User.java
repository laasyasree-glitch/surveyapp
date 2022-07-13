package com.springbootproject.firstspringbootproject.DriverClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//Table
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String userName;
	private String role;
	private String password;
	
	protected User() {
		//Expects private empty no argument constructor
	}
	
	public User(int id, String userName, String role, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.role = role;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + userName + ", role=" + role + ", password=" + password + "]";
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return userName;
	}
	public String getRole() {
		return role;
	}
	public String getPassword() {
		return password;
	}
	
}
