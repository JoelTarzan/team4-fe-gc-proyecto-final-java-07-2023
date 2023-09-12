package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.ISkillUserDAO;
import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.dto.SkillUser;
import com.rest.aurumrh.dto.User;

@Service
public class SkillUserServiceImpl implements ISkillUserService {

	@Autowired
	ISkillUserDAO iSkillUserDAO;

	@Override
	public List<SkillUser> getAllSkillsUsers() {
		
		return iSkillUserDAO.findAll();
	}

	@Override
	public SkillUser getSkillUserById(int id) {
		
		return iSkillUserDAO.findById(id).get();
	}

	@Override
	public SkillUser createSkillUser(SkillUser skillUser) {
		
		return iSkillUserDAO.save(skillUser);
	}

	@Override
	public SkillUser updateSkillUser(SkillUser skillUser) {
		
		return iSkillUserDAO.save(skillUser);
	}

	@Override
	public void deleteSkillUser(int id) {
		
		iSkillUserDAO.deleteById(id);
	}

	@Override
	public List<SkillUser> getAllSkillUserByUser(User user) {
		
		return iSkillUserDAO.findAllByUser(user);
	}

	@Override
	public List<SkillUser> getAllSkillUserBySkill(Skill skill) {
		
		return iSkillUserDAO.findAllBySkill(skill);
	}

	@Override
	public List<SkillUser> getAllSkillUserByUserAndSkill(User user, Skill skill) {
		
		return iSkillUserDAO.findAllByUserAndSkill(user, skill);
	}
}