package com.example.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	private final EmployeeRepository employeeRepository;

	@Override
	public EmployeeModel createEmployee(EmployeeModel employeeModel) {
		
		return employeeRepository.createEmployee(employeeModel);
	}

	@Override
	public Map<Integer, EmployeeModel> displayAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.displayAllEmployees();
	}

}
