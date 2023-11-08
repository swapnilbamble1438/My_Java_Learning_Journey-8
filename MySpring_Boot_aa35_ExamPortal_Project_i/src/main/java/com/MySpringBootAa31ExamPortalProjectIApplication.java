package com;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.model.Role;
import com.model.User;
import com.model.User_role;
import com.service.UserService;

@SpringBootApplication
public class MySpringBootAa31ExamPortalProjectIApplication implements CommandLineRunner{

	
	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootAa31ExamPortalProjectIApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	// creating user without api	
		/*
		User user1 = new User();
		user1.setUsername("swapnilbamble");
		user1.setFirstname("Swapnil");
		user1.setLastname("Bamble");
		user1.setPassword("1234");
		user1.setEmail("swapnil@gmail.com");
		user1.setPhone("1234567891");
		user1.setProfile("default.png");
		*/
//========  Role  ====================================================================================		
		/*
		Role role1 = new Role();
		role1.setRid(1);
		role1.setRolename("ROLE_ADMIN");
		*/
//============================================================================================		
		/*
		User_role user_role1 = new User_role();
		user_role1.setRole(role1);
		user_role1.setUser(user1);
		
		
		Set<User_role> user_roles = new HashSet<>();
		user_roles.add(user_role1);
		
		User createuser1 = this.userService.createUser(user1, user_roles);
		System.out.println("================================================================");
		System.out.println(createuser1.getUsername());
		System.out.println("================================================================");
		*/
		
	}

}
