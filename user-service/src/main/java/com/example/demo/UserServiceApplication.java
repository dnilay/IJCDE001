package com.example.demo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableEurekaClient
public class UserServiceApplication {

	private final UserRepository userRepository;

	@PostConstruct
	public void initData() {
		List<UserEntity> users = Stream
				.of(new UserEntity(1, UUID.randomUUID().toString(), "user1@email.com", "pass1234"),
						new UserEntity(2, UUID.randomUUID().toString(), "user2@email.com", "pass1234"),
						new UserEntity(3, UUID.randomUUID().toString(), "user3@email.com", "pass1234"),
						new UserEntity(4, UUID.randomUUID().toString(), "user4@email.com", "pass1234"))
				.collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
