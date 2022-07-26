package com.springbootproject.firstspringbootproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class JWTResponse {
	private String userole;
	private String jwtToken;
	public JWTResponse(String token, String role) {
		this.jwtToken=token;
		this.userole=role;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}