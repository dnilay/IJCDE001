package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HelloWorldController {

	
	private final Environment environment;
	
	@GetMapping("/status")
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("hello-world-ws is up and running on port: "+environment.getProperty("local.server.port"));
	}
}
