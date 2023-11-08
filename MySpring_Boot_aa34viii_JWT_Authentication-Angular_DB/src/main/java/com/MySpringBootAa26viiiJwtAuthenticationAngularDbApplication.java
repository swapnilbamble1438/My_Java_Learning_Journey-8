package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.model.User;
import com.repo.UserRepository;

@SpringBootApplication
public class MySpringBootAa26viiiJwtAuthenticationAngularDbApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootAa26viiiJwtAuthenticationAngularDbApplication.class, args);
	
	
	}

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {

		User user1 = new User();
		user1.setId(1);
		user1.setUsername("Swapnil");
		user1.setPassword("1234");
		user1.setRole("ROLE_ADMIN");
		user1.setEnabled(true);
		
		this.userRepo.save(user1);
		
		User user2 = new User();
		user2.setId(2);
		user2.setUsername("Yash");
		user2.setPassword("1234");
		user2.setRole("ROLE_USER");
		user2.setEnabled(true);
		
		this.userRepo.save(user2);
		
		
		
		
	}
	
	
	

}
