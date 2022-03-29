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
	private int id;
	@Column(name = "user_id",nullable = false,unique = true)
	private String userId;
	@Column(name = "first_name",nullable = false)
	private String firstName;
	@Column(name = "lastName",nullable = false)
	private String lastName;
	@Column(name = "email",nullable = false,unique = true)
	private String email;
	@Column(name = "encrypted_password")
	private String encryptedPassword;
}
