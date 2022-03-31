package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderEntity;
import com.example.demo.repo.OrderRepo;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
	
	
	private OrderRepo orderRepo;
	@GetMapping("/")
	public List<OrderEntity> fetthAllOrders()
	{
		return orderRepo.findAll();
	}

}
