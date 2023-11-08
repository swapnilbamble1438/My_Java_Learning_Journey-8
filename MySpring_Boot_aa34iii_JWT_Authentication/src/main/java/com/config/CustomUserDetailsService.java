package com.config;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		if(userName.equals("swapnil"))
		{
			return new User("swapnil","1234",new ArrayList<>());// fake service 
			                                                    // fake username or password
			
		}
		else {
			throw new UsernameNotFoundException("User not Found !!");
		}
	
	}

}
