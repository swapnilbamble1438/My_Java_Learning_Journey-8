package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.config.CustomUserDetailsService;
import com.helper.JwtUtil;
import com.model.JwtRequest;
import com.model.JwtResponse;

@RestController
@CrossOrigin(origins = "*")      // @CrossOrigin(origins = "*")
public class JwtController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/*
	  In Postman App
	  Body->raw JSON
	  	
	  	{
	  		"username":"swapnil",
	  		"password":"1234"
	  	}
	 */	
	@PostMapping("/token") // when trying this url,select auth type: No Auth
	public ResponseEntity<?> generateToken(
			@RequestBody JwtRequest jwtRequest) throws Exception
	{
		System.out.println("started...");
		System.out.println(jwtRequest);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		
		} catch(BadCredentialsException e)
		{
			e.printStackTrace();
			
			throw new Exception("Bad Credentials");
		}
		
		// fine area..
		
		final UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		System.out.println("userDetails.getUsername: "   +userDetails.getUsername());
	
	final String token =	jwtUtil.generateToken(userDetails);
	
	System.out.println("token: " + token);
	
	
	// {"token":"value"}
	
	return ResponseEntity.ok(new JwtResponse(token));
	}

}
