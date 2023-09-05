package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.SkillCandidature;

public interface ISkillCandidatureService {

	public List<SkillCandidature> getAllSkillsCandidatures();

	public SkillCandidature getSkillCandidatureById(int id);

	public SkillCandidature createSkillCandidature(SkillCandidature skillCandidature);

	public SkillCandidature updateSkillCandidature(SkillCandidature skillCandidature);

	public void deleteSkillCandidature(int id);
}