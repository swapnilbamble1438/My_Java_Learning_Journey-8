package com.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.config.AppConstants;
import com.entites.Role;
import com.entites.User;
import com.exceptions.ResourceNotFoundException;
import com.payloads.UserDto;
import com.repositories.RoleRepo;
import com.repositories.UserRepo;
import com.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = DtoToUser(userDto);
		User savedUser = userRepo.save(user);
		
		return UserToDto(savedUser);
	
	}



	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateduser = userRepo.save(user);
	UserDto updateduserDto	= UserToDto(updateduser);
		
		return updateduserDto;
	}



	@Override
	public UserDto getUserById(Integer userId) {

		User user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
			
		
		return UserToDto(user);
	}



	@Override
	public List<UserDto> getAllUsers() {

	List<User>	users = userRepo.findAll();
	
	List<UserDto> userDtos =	users.stream().map(user->UserToDto(user)).collect(Collectors.toList());
	
	
		return userDtos;
	}



	@Override
	public void deleteUser(Integer userId) {


		User user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
			
		userRepo.delete(user);
	}
	
	
	public User DtoToUser(UserDto userDto)
	{
//		User user = new User();
//		user.setId(userDto.getId());           // No need to write this code
//		user.setName(userDto.getName());       // since we are using
//		user.setEmail(userDto.getEmail());     // ModelMapper
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
//		return user;
		
		User user = modelMapper.map(userDto,User.class);  // it will convert itself
				return user;
	}
	
	public UserDto UserToDto(User user)
	{
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
//		return userDto;
		
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	
	}



	@Override
	public Optional<User> getUserByEmail(String email) {
		
	return	userRepo.findByEmail(email);
	}



	@Override
	public UserDto registerNewUser(UserDto userDto) {
		
	User user =	modelMapper.map(userDto, User.class);
		
	// encoded the password
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	
	// roles
	Role role = roleRepo.findById(AppConstants.NORMAL_USER).get();
	user.getRoles().add(role);
	
	User newUser = userRepo.save(user);
	
		return modelMapper.map(newUser, UserDto.class);
	}
	

}
