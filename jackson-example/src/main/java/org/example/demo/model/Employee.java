package org.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;

}
