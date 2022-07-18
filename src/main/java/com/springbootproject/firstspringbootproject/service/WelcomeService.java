package com.springbootproject.firstspringbootproject.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service //or Component
public class WelcomeService{
	@Value("${welcome.message}")
	private String welcomeMessage;
	public String retrieveWelcomeMessage() {
		//Complex Method
		return welcomeMessage;
	}
}