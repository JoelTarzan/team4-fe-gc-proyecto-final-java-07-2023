package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.ISkillCandidatureDAO;
import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.dto.SkillCandidature;

@Service
public class SkillCandidatureServiceImpl implements ISkillCandidatureService {

	@Autowired
	ISkillCandidatureDAO iSkillCandidatureDAO;

	@Override
	public List<SkillCandidature> getAllSkillsCandidatures() {
		
		return iSkillCandidatureDAO.findAll();
	}

	@Override
	public SkillCandidature getSkillCandidatureById(int id) {
		
		return iSkillCandidatureDAO.findById(id).get();
	}

	@Override
	public SkillCandidature createSkillCandidature(SkillCandidature skillCandidature) {
		
		return iSkillCandidatureDAO.save(skillCandidature);
	}

	@Override
	public SkillCandidature updateSkillCandidature(SkillCandidature skillCandidature) {
		
		return iSkillCandidatureDAO.save(skillCandidature);
	}

	@Override
	public void deleteSkillCandidature(int id) {
		
		iSkillCandidatureDAO.deleteById(id);
	}

	@Override
	public List<SkillCandidature> getAllSkillCandidaturesBySkill(Skill skill) {
		
		return iSkillCandidatureDAO.findBySkill(skill);
	}

	@Override
	public List<SkillCandidature> getAllSkillCandidaturesByCandidature(Candidature candidature) {
		
		return iSkillCandidatureDAO.findByCandidature(candidature);
	}
}