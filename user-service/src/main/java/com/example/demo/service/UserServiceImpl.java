package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepository;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;

	@Override
	public UserResponseModel createUser(UserDto userDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		StringBuffer stringBuffer=new StringBuffer(userDto.getPassword());
		UserEntity userEntity=modelMapper.map(userDto, UserEntity.class);
		userEntity.setEncryptedPassword(stringBuffer.reverse().toString());
		
		return modelMapper.map(userRepository.save(userEntity), UserResponseModel.class);
	}

}
