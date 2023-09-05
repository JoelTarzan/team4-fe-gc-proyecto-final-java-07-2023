package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.ISkillDAO;
import com.rest.aurumrh.dto.Skill;

@Service
public class SkillServiceImpl implements ISkillService {

	@Autowired
	ISkillDAO iSkillDAO;
	
	@Override
	public List<Skill> getAllSkills() {
		
		return iSkillDAO.findAll();
	}

	@Override
	public Skill getSkillById(int id) {
		
		return iSkillDAO.findById(id).get();
	}

	@Override
	public Skill createSkill(Skill skill) {
		
		return iSkillDAO.save(skill);
	}

	@Override
	public Skill updateSkill(Skill skill) {
		
		return iSkillDAO.save(skill);
	}

	@Override
	public void deleteSkill(int id) {
		
		iSkillDAO.deleteById(id);
		
	}

}
