package com.example.demo.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
	private final ModelMapper modelMapper;
	private final UserService userService;

	@PostMapping("/users")
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userDetails) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
	}

}
