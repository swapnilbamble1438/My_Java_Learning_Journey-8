package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
	
	@Query("select v from User v where v.username = :username")
	public User getByUsername(@Param("username")String username);
	

	
	
}
