package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.OrderDao;
import com.example.demo.model.Order;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class OrderServiceCiCdApplication implements CommandLineRunner{
	
	private final OrderDao orderDao;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceCiCdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		orderDao.save(new Order(1,"Pencil",4,2l));
		orderDao.save(new Order(2,"Pen",2,1l));
		orderDao.save(new Order(3,"iPad",4,2009l));
		orderDao.save(new Order(4,"Laptop",5,990l));
		orderDao.save(new Order(5,"Desktop",6,1022l));
		orderDao.save(new Order(6,"Speaker",1,299l));
	}

}
