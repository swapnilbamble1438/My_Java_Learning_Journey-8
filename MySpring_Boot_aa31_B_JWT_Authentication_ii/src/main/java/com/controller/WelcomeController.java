package com.controller;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.config.CustomUserDetailsService;
import com.entity.AuthRequest;
import com.util.JwtUtil;

@RestController
public class WelcomeController {
	
	@Autowired
	private CustomUserDetailsService cServ;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to learning JWT Authentication";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception
	{
		try
		{
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
		}
		catch(Exception e)
		{
			throw new Exception("inavlid username or password");
		}
		
		final UserDetails userDetails = cServ.loadUserByUsername(authRequest.getUsername());
		
		final String token = jwtUtil.generateToken(userDetails);
		
		return token;
	}
	

}
