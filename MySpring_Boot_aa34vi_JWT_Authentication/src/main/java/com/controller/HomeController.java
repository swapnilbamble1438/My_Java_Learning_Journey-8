package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exceptions.ResourceNotFoundException;

@RestController
public class HomeController {

	
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
	public String getUser()
	{
		return "{\"name\":\"swapnil\"}";
	}
	
}
