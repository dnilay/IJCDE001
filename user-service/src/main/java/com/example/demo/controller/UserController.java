package com.example.demo.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	@PostMapping("/users")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userEntity));
	}
	@GetMapping("/users/{uniqueId}")
	public ResponseEntity<?> findUserByUniqueId(@PathVariable("uniqueId") String uniqueId)
	{
		Optional<UserEntity> optional=userService.findUserByUniqueId(uniqueId);
		if(!optional.isPresent())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user with uniqueId "+uniqueId+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(optional.get());
		}
		
	}

}
