package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDao;
@Repository
public interface UserRepository extends CrudRepository<UserDao, Integer> {
	UserDao findByUsername(String username);
}