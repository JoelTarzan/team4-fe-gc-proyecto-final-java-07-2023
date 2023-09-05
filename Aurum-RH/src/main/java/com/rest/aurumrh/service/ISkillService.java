package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Skill;

public interface ISkillService {

	public List<Skill> getAllSkills();
	
	public Skill getSkillById(int id);
	
	public Skill createSkill(Skill skill);
	
	public Skill updateSkill(Skill skill);
	
	public void deleteSkill(int id);
}