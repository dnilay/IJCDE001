package com.example.demo.repo;

import java.util.Map;

import com.example.demo.model.EmployeeModel;

public interface EmployeeRepository {

	public EmployeeModel createEmployee(EmployeeModel employeeModel);

	public Map<Integer, EmployeeModel> displayAllEmployees();

}
