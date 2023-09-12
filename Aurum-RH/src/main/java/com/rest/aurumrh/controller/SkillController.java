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

import com.rest.aurumrh.dto.Skill;
import com.rest.aurumrh.service.SkillServiceImpl;

@RestController
public class SkillController {

	@Autowired
	SkillServiceImpl skillServiceImpl;
	
	@GetMapping("/skills")
	public List<Skill> getAllSkills() {
		
		return skillServiceImpl.getAllSkills();
	}
	
	@GetMapping("/skills/{id}")
	public Skill getSkillById(@PathVariable(name = "id") int id) {
		
		return skillServiceImpl.getSkillById(id);
	}
	
	@PostMapping("/skills")
	public Skill createSkill(@RequestBody Skill skill) {
		
		return skillServiceImpl.createSkill(skill);
	}
	
	@PutMapping("/skills/{id}")
	public Skill updateSkill(@PathVariable(name = "id") int id, @RequestBody Skill skill) {
		
		Skill selectedSkill = new Skill();
		Skill updatedSkill = new Skill();
		
		selectedSkill = skillServiceImpl.getSkillById(id);
		
		selectedSkill.setName(skill.getName());
		
		updatedSkill = skillServiceImpl.updateSkill(selectedSkill);
		
		return updatedSkill;
	}
	
	@DeleteMapping("/skills/{id}")
	public void deleteSkill(@PathVariable(name = "id") int id) {
		
		skillServiceImpl.deleteSkill(id);
	}
	
	@GetMapping("/skills/name/{name}")
	public Skill getSkillByName(@PathVariable(name = "name") String name) {
		
		return skillServiceImpl.getSkillByName(name);
	}
}