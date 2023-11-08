package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entites.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
	// custom methods
	
	Optional<User> findByEmail(String email);
	
	
	
}
