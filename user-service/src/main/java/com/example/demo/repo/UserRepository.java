package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	
	@Query
	public Optional<UserEntity> findByUniqueId(String uniqueId);
	@Query
	public Optional<UserEntity> findByEmail(String email);

}
