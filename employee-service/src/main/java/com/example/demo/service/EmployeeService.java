package com.example.demo.service;

import java.util.Map;

import com.example.demo.model.EmployeeModel;

public interface EmployeeService {

	public EmployeeModel createEmployee(EmployeeModel employeeModel);
	
	public Map<Integer,EmployeeModel> displayAllEmployees();

}
