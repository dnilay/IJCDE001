package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id",nullable = false)
	private int userId;
	@Column(name = "unique_id",unique =true,nullable = false)
	private String uniqueId;
	@Column(name = "email",unique = true,nullable = false)
	private String email;
	@Column(name = "password",nullable = false)
	private String password;

}
