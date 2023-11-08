package com;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.User;
import com.repository.UserRepository;

@SpringBootApplication
public class MySpringBootAa30JwtAuthenticationIiApplication {

	@Autowired
	private UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootAa30JwtAuthenticationIiApplication.class, args);
	}
	
	@PostConstruct
	public void initUsers()
	{
		
		List<User> users = Stream.of(new User(1,"Swapnil","1234","swapnil@gmail.com"),
				new User(2,"Yash","1234","yash@gmail.com")).collect(Collectors.toList());
			
		userRepo.saveAll(users);
		
	}

}
