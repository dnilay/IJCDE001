package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repo.ProductRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	@Override
	public ProductEntity createProduct(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		return productRepository.save(productEntity);
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public ProductEntity findProductById(int productId) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> productEntity=productRepository.findById(productId);
		if(!productEntity.isPresent())
		{
			throw new ProductNotFoundException("product with the product id: "+productId+" not found");
		}
		return productEntity.get();
	}

}
