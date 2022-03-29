package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserNotFoundException;
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
		StringBuffer stringBuffer = new StringBuffer(userDto.getPassword());
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		userEntity.setEncryptedPassword(stringBuffer.reverse().toString());

		return modelMapper.map(userRepository.save(userEntity), UserResponseModel.class);
	}

	@Override
	public List<UserResponseModel> getAllUsers() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserResponseModel> userResponseModels = new ArrayList<UserResponseModel>();
		List<UserEntity> list = userRepository.findAll();

		Iterator<UserEntity> i=list.iterator();
		while(i.hasNext())
		{
			UserResponseModel model= modelMapper.map(i.next(), UserResponseModel.class);
			userResponseModels.add(model);
		}
		return userResponseModels;
	}

	@Override
	public UserResponseModel findUserByUserId(String userId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity=userRepository.findByUserId(userId);
		if(userEntity==null)
		{
			throw new UserNotFoundException("user is not found");
		}
		return modelMapper.map(userEntity, UserResponseModel.class);
	}

}
