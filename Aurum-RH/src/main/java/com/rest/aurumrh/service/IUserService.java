package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Role;
import com.rest.aurumrh.dto.SkillUser;
import com.rest.aurumrh.dto.User;

public interface IUserService {

	public List<User> getAllUsers();

	public User getUserById(int id);

	public User createUser(User user);

	public User updateUser(User user);

	public void deleteUser(int id);

	// Users ordenados alfabeticamente ASC
	public List<User> getAllUsersASC();

	// Users ordenados alfabeticamente DESC
	public List<User> getAllUsersDESC();

	// Users que empiezan por X letras
	public List<User> getAllUsersStartingWith(String letters);

	// Buscar usuarios por rol y ordenados alfabeticamente de forma ASC
	public List<User> getAllUsersByRoleASC(Role role);

	// Buscar usuarios por rol y ordenados alfabeticamente de forma DESC
	public List<User> getAllUsersByRoleDESC(Role role);

	// Buscar usuarios por rol y que empiecen por X letras
	public List<User> getAllUsersByRoleStartingWith(Role role, String letters);

	// Buscar usuarios por rol, que cumplen determinadas aptitudes (SkillUser), ordenados alfabeticamente de forma ASC
	public List<User> getAllUsersByRoleBySkillsUsersASC(Role role, List<SkillUser> skillsUsers);

	// Buscar usuarios por rol, que cumplen determinadas aptitudes (SkillUser), ordenados alfabeticamente de forma DESC
	public List<User> getAllUsersByRoleBySkillsUsersDESC(Role role, List<SkillUser> skillsUsers);

	// Buscar usuarios por rol, cumplen determinadas aptitudes (SkillUser) y que empiezan por X letras
	public List<User> getAllUsersByRoleBySkillsUsersStartingWith(Role role, String letters, List<SkillUser> skillsUsers);
}