package com.springbootproject.firstspringbootproject.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTRequest {
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

}