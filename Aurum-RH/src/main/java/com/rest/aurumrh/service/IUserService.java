package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.User;

public interface IUserService {

	public List<User> getAllUsers();
	
	public User getUserById(int id);
	
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(int id);
}