package com.example.demo.repo;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeModel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private final Map<Integer, EmployeeModel> employeeMap;

	@Override
	public EmployeeModel createEmployee(EmployeeModel employeeModel) {
		employeeMap.put(new Random().nextInt(1000), employeeModel);
		return employeeModel;
	}

	@Override
	public Map<Integer, EmployeeModel> displayAllEmployees() {
		// TODO Auto-generated method stub
		return employeeMap;
	}

}
