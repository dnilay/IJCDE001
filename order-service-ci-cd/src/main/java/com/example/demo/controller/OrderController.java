package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.OrderDao;
import com.example.demo.model.Order;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
public class OrderController {
	
	private final OrderDao orderDao;
	
	@RequestMapping
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("order-service is up..");
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getOrders()
	{
		return ResponseEntity.ok(orderDao.findAll());
	}
	@GetMapping("/orders/{id}")
	public ResponseEntity<?> findOrderByid(@PathVariable("id") int id)
	{
		return ResponseEntity.ok(orderDao.findById(id));
	}
	

}
