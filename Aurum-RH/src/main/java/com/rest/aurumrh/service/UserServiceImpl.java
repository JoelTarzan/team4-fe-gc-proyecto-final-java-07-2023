package com.rest.aurumrh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.IUserDAO;
import com.rest.aurumrh.dto.Role;
import com.rest.aurumrh.dto.SkillUser;
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

	@Override
	public Optional<User> getUserByEmail(String email) {

		return iUserDAO.findByEmail(email);
	}

	@Override
	public List<User> getAllUsersASC() {

		return iUserDAO.findAllByOrderByNameAsc();
	}

	@Override
	public List<User> getAllUsersDESC() {

		return iUserDAO.findAllByOrderByNameDesc();
	}
	
	@Override
	public List<User> getAllUserOrderByRole() {
		
		return iUserDAO.findAllByOrderByRole();
	}

	@Override
	public List<User> getAllUsersStartingWith(String letters) {

		return iUserDAO.findByNameStartingWithIgnoreCase(letters);
	}

	@Override
	public List<User> getAllUsersByRoleASC(Role role) {

		return iUserDAO.findByRoleOrderByNameAsc(role);
	}

	@Override
	public List<User> getAllUsersByRoleDESC(Role role) {

		return iUserDAO.findByRoleOrderByNameDesc(role);
	}

	@Override
	public List<User> getAllUsersByRoleStartingWith(Role role, String letters) {

		return iUserDAO.findByRoleAndNameStartingWithIgnoreCase(role, letters);
	}

	@Override
	public List<User> getAllUsersByRoleBySkillsUsersASC(Role role, List<SkillUser> skillsUsers) {

		return iUserDAO.findByRoleAndSkillsUsersInOrderByNameAsc(role, skillsUsers);
	}

	@Override
	public List<User> getAllUsersByRoleBySkillsUsersDESC(Role role, List<SkillUser> skillsUsers) {

		return iUserDAO.findByRoleAndSkillsUsersInOrderByNameDesc(role, skillsUsers);
	}

	@Override
	public List<User> getAllUsersByRoleBySkillsUsersStartingWith(Role role, String letters, List<SkillUser> skillsUsers) {

		return iUserDAO.findByRoleAndNameStartingWithIgnoreCaseAndSkillsUsersIn(role, letters, skillsUsers);
	}
}