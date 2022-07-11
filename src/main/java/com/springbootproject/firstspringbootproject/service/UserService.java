package com.springbootproject.firstspringbootproject.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype. Service;
import com.springbootproject.firstspringbootproject.jpa.UserRepository;
@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.springbootproject.firstspringbootproject.jpa.User> newUser= userRepository.findByUserName(username);
		System.out.println(newUser.get());
		if(newUser.isPresent())
			return new User(newUser.get().getName(),newUser.get().getPassword(),
				AuthorityUtils.commaSeparatedStringToAuthorityList(newUser.get().getRole()));
			
		else
			throw new UsernameNotFoundException("User name not found");
	}
	
}