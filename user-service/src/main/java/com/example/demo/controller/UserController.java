package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	private final org.springframework.core.env.Environment environment;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("user-service is up and running on port: "+environment.getProperty("local.server.port"));
	}

	@PostMapping("/users")
	public ResponseEntity<UserResponseModel> createUser(@Validated @Valid @RequestBody UserRequestModel userDetails) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
	}

	@GetMapping("/users")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<UserResponseModel> getAllUsers() {

		return userService.getAllUsers();
	}

	@GetMapping("/users/{userId}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public UserResponseModel findUserByUserId(@PathVariable("userId") String userId) {
		return userService.findUserByUserId(userId);
	}

}
