package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.IUserDAO;
import com.rest.aurumrh.dto.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDAO iUserDAO;

	@Override
	public List<User> getAllUsers() {
		
		return iUserDAO.findAll();
	}

	@Override
	public User getUserById(int id) {
		
		return iUserDAO.findById(id).get();
	}

	@Override
	public User createUser(User user) {
		
		return iUserDAO.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		return iUserDAO.save(user);
	}

	@Override
	public void deleteUser(int id) {
		
		iUserDAO.deleteById(id);
	}
}