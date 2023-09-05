package com.rest.aurumrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Role;
import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.dto.User;

public interface IUserDAO extends JpaRepository<User, Integer> {

	// Usuarios ordenados alfabeticamente de forma ASC
	public List<User> findAllByOrderByNameAsc();

	// Usuarios ordenados alfabeticamente de forma DESC
	public List<User> findAllByOrderByNameDesc();

	// Buscar usuarios que empiecen por X letras
	public List<User> findByNameStartingWithIgnoreCase(String letters);

	// Buscar usuarios por rol y ordenados alfabeticamente de forma ASC
	public List<User> findByRoleOrderByNameAsc(Role role);

	// Buscar usuarios por rol y ordenados alfabeticamente de forma DESC
	public List<User> findByRoleOrderByNameDesc(Role role);

	// Buscar usuarios por rol y que empiecen por X letras
	public List<User> findByRoleAndNameStartingWithIgnoreCase(Role role, String letters);

	// Buscar usuarios por rol, que cumplen determinadas aptitudes, ordenados alfabeticamente de forma ASC
	public List<User> findByRoleAndSkillsInOrderBynameAsc(Role role, List<Skill> skills);

	// Buscar usuarios por rol, que cumplen determinadas aptitudes, ordenados alfabeticamente de forma DESC
	public List<User> findByRoleAndSkillsInOrderBynameDesc(Role role, List<Skill> skills);

	// Buscar usuarios por rol, que empiezan por X letras y cumplen determinadas aptitudes, ordenados alfabeticamente de forma ASC
	public List<User> findByRoleAndNameStartingWithIgnoreCaseAndSkillsInOrderBynameAsc(Role role, String letters, List<Skill> skills);

	// Buscar usuarios por rol, que empiezan por X letras y cumplen determinadas aptitudes, ordenados alfabeticamente de forma DESC
	public List<User> findByRoleAndNameStartingWithIgnoreCaseAndSkillsInOrderBynameDesc(Role role, String letters, List<Skill> skills);
}