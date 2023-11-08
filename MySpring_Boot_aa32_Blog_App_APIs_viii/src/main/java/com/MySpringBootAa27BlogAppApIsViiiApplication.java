package com;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringBootAa27BlogAppApIsViiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootAa27BlogAppApIsViiiApplication.class, args);
	}
	

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
