package com.rest.aurumrh.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rest.aurumrh.dto.Role;
import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.dto.SkillUser;
import com.rest.aurumrh.dto.User;
import com.rest.aurumrh.exception.UserAlreadyExistsException;
import com.rest.aurumrh.service.RoleServiceImpl;
import com.rest.aurumrh.service.SkillUserServiceImpl;
import com.rest.aurumrh.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	RoleServiceImpl roleServiceImpl;

	@Autowired
	SkillUserServiceImpl skillUserServiceImpl;

	@Autowired
	PasswordEncoder passwordEncoder;

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
		Optional<User> userFound = userServiceImpl.getUserByEmail(user.getEmail());

		if (userFound.isPresent()) {
			throw new UserAlreadyExistsException("Ya existe un usuario con este email.", HttpStatus.FOUND.value());
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
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

	// Buscar usuario por email
	@GetMapping("/users/email/{email}")
	public Optional<User> getUserByEmail(@PathVariable(name = "email") String email) {

		return userServiceImpl.getUserByEmail(email);
	}

	// Usuarios ordenados alfabeticamente de forma ASC
	@GetMapping("/users/name-asc")
	public List<User> getAllUsersASC() {

		return userServiceImpl.getAllUsersASC();
	}

	// Usuarios ordenados alfabeticamente de forma DESC
	@GetMapping("/users/name-desc")
	public List<User> getAllUsersDESC() {

		return userServiceImpl.getAllUsersDESC();
	}

	// Usuarios ordenados por rol
	@GetMapping("/users/role")
	public List<User> getAllUserOrderByRole() {

		return userServiceImpl.getAllUserOrderByRole();
	}

	// Buscar usuarios que empiecen por X letras
	@GetMapping("/users/search/{letters}")
	public List<User> getAllUsersStartingWith(@PathVariable(name = "letters") String letters) {

		return userServiceImpl.getAllUsersStartingWith(letters);
	}

	// Buscar usuarios por rol y ordenados alfabeticamente de forma ASC
	@PostMapping("/users/role/{rolename}/name-asc")
	public List<User> getAllUsersByRoleASC(@PathVariable(name = "rolename") String rolename) {
		Role role = roleServiceImpl.getRoleByName(rolename);

		return userServiceImpl.getAllUsersByRoleASC(role);
	}

	// Buscar usuarios por rol y ordenados alfabeticamente de forma DESC
	@PostMapping("/users/role/{rolename}/name-desc")
	public List<User> getAllUsersByRoleDESC(@PathVariable(name = "rolename") String rolename) {
		Role role = roleServiceImpl.getRoleByName(rolename);

		return userServiceImpl.getAllUsersByRoleDESC(role);
	}

	// Buscar usuarios por rol y que empiecen por X letras
	@PostMapping("/users/role/{rolename}/search/{letters}")
	public List<User> getAllUsersByRoleStartingWith(@PathVariable(name = "rolename") String rolename, @PathVariable(name = "letters") String letters) {
		Role role = roleServiceImpl.getRoleByName(rolename);

		return userServiceImpl.getAllUsersByRoleStartingWith(role, letters);
	}

	// Buscar usuarios por rol, que cumplen determinadas aptitudes (SkillUser), ordenados alfabeticamente de forma ASC
	@PostMapping("/candidates/skills/name-asc")
	public List<User> getAllCandidatesSkillsASC(@RequestBody List<Skill> skills) {

		Role candidateRole = roleServiceImpl.getRoleById(3);
		List<SkillUser> skillsUsers = new ArrayList<SkillUser>();

		for (Skill skill : skills) {
			skillsUsers.addAll(skillUserServiceImpl.getAllSkillUserBySkill(skill));
		}

		return userServiceImpl.getAllUsersByRoleBySkillsUsersASC(candidateRole, skillsUsers);
	}

	// Buscar usuarios por rol, que cumplen determinadas aptitudes (SkillUser), ordenados alfabeticamente de forma DESC
	@PostMapping("/candidates/skills/name-desc")
	public List<User> getAllCandidatesBySkillsUsersDESC(@RequestBody List<Skill> skills) {

		Role candidateRole = roleServiceImpl.getRoleById(3);
		List<SkillUser> skillsUsers = new ArrayList<SkillUser>();

		for (Skill skill : skills) {
			skillsUsers.addAll(skillUserServiceImpl.getAllSkillUserBySkill(skill));
		}

		return userServiceImpl.getAllUsersByRoleBySkillsUsersDESC(candidateRole, skillsUsers);
	}

	// Buscar usuarios por rol, cumplen determinadas aptitudes (SkillUser) y que empiezan por X letras
	@PostMapping("/candidates/skills/search/{letters}")
	public List<User> getAllUsersByRoleBySkillsUsersStartingWith(@PathVariable(name = "letters") String letters, @RequestBody List<Skill> skills) {

		Role candidateRole = roleServiceImpl.getRoleById(3);
		List<SkillUser> skillsUsers = new ArrayList<SkillUser>();

		for (Skill skill : skills) {
			skillsUsers.addAll(skillUserServiceImpl.getAllSkillUserBySkill(skill));
		}

		return userServiceImpl.getAllUsersByRoleBySkillsUsersStartingWith(candidateRole, letters, skillsUsers);
	}
}