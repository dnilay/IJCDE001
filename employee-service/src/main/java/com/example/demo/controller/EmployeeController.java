package com.example.demo.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class EmployeeController {
	private final Environment environment;
	private final EmployeeService employeeService;

	/*
	 * @GetMapping(produces ="application/json",value = "/employees") public
	 * EmployeeModel displayNewEmployee() { Address
	 * address=Address.builder().addresLine1("AA").
	 * addressLine2("AAA").city("Hyd").country(Country.INDIA).build(); EmployeeModel
	 * employeeModel=EmployeeModel.builder().employeeId(UUID.randomUUID().toString()
	 * ) .employeeName("John").salary(20000.0).address(address).build(); return
	 * employeeModel;
	 * 
	 * }
	 */
	
	@GetMapping("/")
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("employee-service is up and running on port: "+environment.getProperty("local.server.port"));
	}

	@PostMapping("/employees")
	public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employeeModel) {
		log.info("insereting data into map");
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeModel));
	}

	@GetMapping("/employees")
	public ResponseEntity<Collection<EmployeeModel>> displayAllEmployees() {
		Map<Integer, EmployeeModel> map = employeeService.displayAllEmployees();
		log.info("{}", map.keySet());
		return ResponseEntity.ok(map.values());
	}
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeModel> findEmployee(@PathVariable("employeeId") int employeeId)
	{
		EmployeeModel model=employeeService.findEmployeeById(employeeId);
		if(model==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(model);
	}

}
