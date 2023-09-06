package com.rest.aurumrh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.aurumrh.dto.User;
import com.rest.aurumrh.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return userServiceImpl.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(name = "id") int id) {
		
		return userServiceImpl.getUserById(id);
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		
		return userServiceImpl.createUser(user);
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(name = "id") int id, @RequestBody User user) {
		
		User selectedUser = new User();
		User updatedUser = new User();
		
		selectedUser = userServiceImpl.getUserById(id);
		
		selectedUser.setName(user.getName());
		selectedUser.setLastname(user.getLastname());
		selectedUser.setEmail(user.getEmail());
		selectedUser.setPassword(user.getPassword());
		selectedUser.setDescription(user.getDescription());
		selectedUser.setRating(user.getRating());
		selectedUser.setTitle(user.getTitle());
		selectedUser.setPhone(user.getPhone());
		selectedUser.setWeb(user.getWeb());
		selectedUser.setLinkedin(user.getLinkedin());
		selectedUser.setGit(user.getGit());
		selectedUser.setAvatar(user.getAvatar());
		selectedUser.setRole(user.getRole());
		
		updatedUser = userServiceImpl.updateUser(selectedUser);
		
		return updatedUser;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name = "id") int id) {
		
		userServiceImpl.deleteUser(id);
	}
}