package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;

	@Override
	public UserEntity createUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userEntity.setUniqueId(UUID.randomUUID().toString());
		return userRepository.save(userEntity);
	}

	@Override
	public Optional<UserEntity> findUserByUniqueId(String uniqueId) {
		// TODO Auto-generated method stub
		Optional<UserEntity> userEOptional=userRepository.findByUniqueId(uniqueId);
	
		return userEOptional;
	}

	@Override
	public Optional<UserEntity> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

}
