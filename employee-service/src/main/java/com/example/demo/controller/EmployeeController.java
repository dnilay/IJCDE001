package com.example.demo.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Country;
import com.example.demo.model.EmployeeModel;

@RestController
public class EmployeeController {
	@GetMapping(produces ="application/json",value  = "/employees")
	public EmployeeModel displayNewEmployee()
	{
		Address address=Address.builder().addresLine1("AA").
				addressLine2("AAA").city("Hyd").country(Country.INDIA).build();
		EmployeeModel employeeModel=EmployeeModel.builder().employeeId(UUID.randomUUID().toString())
				.employeeName("John").salary(20000.0).address(address).build();
		return employeeModel;
		
	}

}
