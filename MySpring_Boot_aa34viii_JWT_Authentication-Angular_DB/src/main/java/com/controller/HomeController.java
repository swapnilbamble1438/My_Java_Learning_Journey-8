package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exceptions.ResourceNotFoundException;
import com.model.User;
import com.repo.UserRepository;

@RestController
@CrossOrigin(origins = "*")      // @CrossOrigin(origins = "*")
public class HomeController {

	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/welcome")
	public String welcome()	
	{
			String text = "This is private page";
			
			text += "This page is not allowed to unauthenticated users.";
			
			return text;
	}
	
	@RequestMapping("/check/{no}")
	public String checkexception(@PathVariable("no") Integer no)
	{
		if(no > 1)
			throw new ResourceNotFoundException();
		
		return "done";
	}
	
	@GetMapping("/getuser")
	public String getUser(Principal p)
	{
		User user = userRepo.getByUsername(p.getName());
		
		System.out.println(user);
		return "{\"name\":\""+user.getUsername()+"\"}";
		
	}
	
}
