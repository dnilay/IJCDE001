package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Employeecontroller {

	private final EmployeeRepository employeeRepository;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepository.save(employee));
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> displayAllEmployees()
	{
		return ResponseEntity.ok(employeeRepository.findAll());
	}
}
