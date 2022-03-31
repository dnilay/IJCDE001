package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.OrderProxy;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MyApp1Controller {

	private RestTemplate restTemplate;

	@GetMapping("/myapp/orders")
	public ResponseEntity<?> fetchOrders() {
		@SuppressWarnings("unchecked")
		List<OrderProxy> list = restTemplate.getForObject("http://localhost:8082/api/orders/", List.class);
		return ResponseEntity.ok(list);
	}

}
