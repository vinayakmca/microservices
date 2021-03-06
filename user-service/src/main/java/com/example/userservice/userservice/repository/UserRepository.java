package com.example.userservice.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.userservice.entity.User;


@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
	
	public User findByFirstName(String name);

}
