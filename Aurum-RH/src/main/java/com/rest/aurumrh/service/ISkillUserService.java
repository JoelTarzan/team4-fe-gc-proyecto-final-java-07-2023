package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.dto.SkillUser;
import com.rest.aurumrh.dto.User;

public interface ISkillUserService {

	public List<SkillUser> getAllSkillsUsers();

	public SkillUser getSkillUserById(int id);

	public SkillUser createSkillUser(SkillUser skillUser);

	public SkillUser updateSkillUser(SkillUser skillUser);

	public void deleteSkillUser(int id);
	
	// Busca las SkillUser a partir de un usuario
	public List<SkillUser> getAllSkillUserByUser(User user);
	
	// Busca las SkillUser a partir de una skill
	public List<SkillUser> getAllSkillUserBySkill(Skill skill);
	
	// Busca las SkillUser a partir de un usuario y una skill
	public List<SkillUser> getAllSkillUserByUserAndSkill(User user, Skill skill);
}