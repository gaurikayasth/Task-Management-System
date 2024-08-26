package com.example.TaskManagementSystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManagementSystem.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByUsernameAndPassword(String username,String password);
}
