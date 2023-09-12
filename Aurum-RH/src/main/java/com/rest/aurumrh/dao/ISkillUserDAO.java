package com.rest.aurumrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.dto.SkillUser;
import com.rest.aurumrh.dto.User;


public interface ISkillUserDAO extends JpaRepository<SkillUser, Integer> {

	// Busca las SkillUser a partir de un usuario
	public List<SkillUser> findAllByUser(User user);

	// Busca las SkillUser a partir de una skill
	public List<SkillUser> findAllBySkill(Skill skill);
	
	// Busca las SkillUser a partir de un usuario y una skill
	public List<SkillUser> findAllByUserAndSkill(User user, Skill skill);
}