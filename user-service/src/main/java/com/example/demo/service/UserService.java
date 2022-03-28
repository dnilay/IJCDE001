package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.UserEntity;

public interface UserService {

	public UserEntity createUser(UserEntity userEntity);
	
	public Optional<UserEntity> findUserByUniqueId(String uniqueId);
	
	public Optional<UserEntity> findUserByEmail(String email);
}
