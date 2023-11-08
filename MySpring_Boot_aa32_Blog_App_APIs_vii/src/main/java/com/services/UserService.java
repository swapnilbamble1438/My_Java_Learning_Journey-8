package com.services;

import java.util.List;
import java.util.Optional;

import com.entites.User;
import com.payloads.UserDto;

public interface UserService {

	
	UserDto  createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
	
	Optional<User> getUserByEmail(String email);
	
	
	
	
}
