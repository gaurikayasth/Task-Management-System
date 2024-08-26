package com.example.TaskManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagementSystem.entity.User;
import com.example.TaskManagementSystem.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/register")
	public User saveUser(@RequestBody User user)
	{
		return userRepo.save(user);
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user)
	{
		return userRepo.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	}
}
