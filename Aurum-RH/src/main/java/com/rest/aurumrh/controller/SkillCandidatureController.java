package com.rest.aurumrh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.OpenProcess;
import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.dto.SkillCandidature;
import com.rest.aurumrh.dto.Subscription;
import com.rest.aurumrh.service.CandidatureServiceImpl;
import com.rest.aurumrh.service.SkillCandidatureServiceImpl;
import com.rest.aurumrh.service.SkillServiceImpl;

@RestController
public class SkillCandidatureController {

	@Autowired
	SkillCandidatureServiceImpl skillCandidatureServiceImpl;
	
	@Autowired
	SkillServiceImpl skillServiceImpl;
	
	@Autowired
	CandidatureServiceImpl candidatureServiceImpl;
	
	@GetMapping("/skillscandidatures")
	public List<SkillCandidature> getAllSkillsCandidatures() {
		
		return skillCandidatureServiceImpl.getAllSkillsCandidatures();
	}
	
	@GetMapping("/skillscandidatures/{id}")
	public SkillCandidature getSkillCandidatureById(@PathVariable(name = "id") int id) {
		
		return skillCandidatureServiceImpl.getSkillCandidatureById(id);
	}
	
	@PostMapping("/skillscandidatures")
	public SkillCandidature createSkillCandidature(@RequestBody SkillCandidature skillCandidature) {
		
		return skillCandidatureServiceImpl.createSkillCandidature(skillCandidature);
	}
	
	@PutMapping("/skillscandidatures/{id}")
	public SkillCandidature updateSkillCandidature(@PathVariable(name = "id") int id, @RequestBody SkillCandidature skillCandidature) {
		
		SkillCandidature selectedSkillCandidature = new SkillCandidature();
		SkillCandidature updatedSkillCandidature = new SkillCandidature();
		
		selectedSkillCandidature = skillCandidatureServiceImpl.getSkillCandidatureById(id);
		
		selectedSkillCandidature.setSkill(skillCandidature.getSkill());
		selectedSkillCandidature.setCandidature(skillCandidature.getCandidature());
		
		updatedSkillCandidature = skillCandidatureServiceImpl.updateSkillCandidature(selectedSkillCandidature);
		
		return updatedSkillCandidature;
	}
	
	@DeleteMapping("/skillscandidatures/{id}")
	public void deleteSkillCandidature(@PathVariable(name = "id") int id) {
		
		skillCandidatureServiceImpl.deleteSkillCandidature(id);
	}
	
	@GetMapping("/skillscandidatures/skill/{id}")
	public List<SkillCandidature> getAllSkillCandidaturesBySkill(@PathVariable(name = "id") int id) {
		
		Skill skill = skillServiceImpl.getSkillById(id);
		
		return skillCandidatureServiceImpl.getAllSkillCandidaturesBySkill(skill);
	}
	
	@GetMapping("/skillscandidatures/candidature/{id}")
	public List<SkillCandidature> getAllSkillCandidaturesByCandidature(@PathVariable(name = "id") int id) {
		
		Candidature candidature = candidatureServiceImpl.getCandidatureById(id);
		
		return skillCandidatureServiceImpl.getAllSkillCandidaturesByCandidature(candidature);
	}
}