package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.dto.SkillCandidature;

public interface ISkillCandidatureService {

	public List<SkillCandidature> getAllSkillsCandidatures();

	public SkillCandidature getSkillCandidatureById(int id);

	public SkillCandidature createSkillCandidature(SkillCandidature skillCandidature);

	public SkillCandidature updateSkillCandidature(SkillCandidature skillCandidature);

	public void deleteSkillCandidature(int id);
	
	    // Por cada skill
		public List<SkillCandidature> getAllSkillCandidaturesBySkill(Skill skill);
		
		// Por cada candidature
		public List<SkillCandidature> getAllSkillCandidaturesByCandidature(Candidature candidature);
}