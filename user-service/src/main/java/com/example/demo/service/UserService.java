package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.ui.UserResponseModel;

public interface UserService {

	public UserResponseModel createUser(UserDto userDto);
	
	public List<UserResponseModel> getAllUsers();
	
	public UserResponseModel findUserByUserId(String userId);
}
