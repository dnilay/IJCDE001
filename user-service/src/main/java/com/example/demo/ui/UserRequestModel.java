package com.example.demo.ui;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequestModel {
	@NotNull
	@NotBlank
	@Size(min = 4,max = 255)
	private String firstName;
	@NotNull
	@NotBlank
	@Size(min = 4,max = 255)
	private String lastName;
	@NotNull
	@Email
	private String email;
	@NotNull
	@NotBlank
	@Size(min = 8,max = 16)
	private String password;

}
