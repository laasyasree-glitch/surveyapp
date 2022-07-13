package com.springbootproject.firstspringbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springbootproject.firstspringbootproject.model.JWTRequest;
import com.springbootproject.firstspringbootproject.model.JWTResponse;
import com.springbootproject.firstspringbootproject.service.UserService;
import com.springbootproject.firstspringbootproject.service.WelcomeService;
import com.springbootproject.firstspringbootproject.utility.JWTUtility;

@RestController
public class WelcomeController {
	
	
	//Auto-wiring
	@Autowired
	private WelcomeService service;
	
	 @Autowired
	    private JWTUtility jwtUtility;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserService userService;
	
		@RequestMapping("/welcome")
		@PreAuthorize("hasAuthority('User')")
		public String welcome() {
			return service.retrieveWelcomeMessage();
		}
		
		@PostMapping("/authenticate")
	    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception{

	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            jwtRequest.getUsername(),
	                            jwtRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }

	        final UserDetails userDetails
	                = userService.loadUserByUsername(jwtRequest.getUsername());

	        final String token =
	                jwtUtility.generateToken(userDetails);

	        return  new JWTResponse(token);
	    }
		

}

//To scan in other package we need to use ComponentScan
//By default search in same package
/*@Repository Annotation is a specialization of @Component 
 annotation which is used to indicate that the class provides 
 the mechanism for storage, retrieval, update, delete 
 and search operation on objects.*/
