package com.rest.aurumrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.dto.SkillCandidature;

public interface ISkillCandidatureDAO extends JpaRepository<SkillCandidature, Integer> {

public List<SkillCandidature> findBySkill(Skill skill);
	
	public List<SkillCandidature> findByCandidature(Candidature candidature);
	
}