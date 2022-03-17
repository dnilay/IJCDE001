package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.EmployeeModel;

@Configuration
public class SpringConfig {

	@Bean
	public Map<Integer, EmployeeModel> employeeMap() {
		return new HashMap<Integer, EmployeeModel>();
	}

}
