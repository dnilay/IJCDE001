package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.OrderEntity;
import com.example.demo.repo.OrderRepo;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class OrderServiceApplication implements CommandLineRunner{
private final OrderRepo orderRepo;
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		orderRepo.save(new OrderEntity(1,"Pen",1.0));
		orderRepo.save(new OrderEntity(2,"Pencil",2.0));
		orderRepo.save(new OrderEntity(3,"Laptop",1999.0));
		orderRepo.save(new OrderEntity(4,"Chocolate",3.0));
		orderRepo.save(new OrderEntity(5,"Book",14.0));
	}

}
