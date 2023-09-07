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
import com.rest.aurumrh.dto.SkillUser;
import com.rest.aurumrh.dto.User;
import com.rest.aurumrh.service.SkillServiceImpl;
import com.rest.aurumrh.service.SkillUserServiceImpl;
import com.rest.aurumrh.service.UserServiceImpl;

@RestController
public class SkillUserController {

	@Autowired
	SkillUserServiceImpl skillUserServiceImpl;

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	SkillServiceImpl skillServiceImpl;

	@GetMapping("/skillsusers")
	public List<SkillUser> getAllSkillsUsers() {

		return skillUserServiceImpl.getAllSkillsUsers();
	}

	@GetMapping("/skillsusers/{id}")
	public SkillUser getSkillUserById(@PathVariable(name = "id") int id) {

		return skillUserServiceImpl.getSkillUserById(id);
	}

	@PostMapping("/skillsusers")
	public SkillUser createSkillUser(@RequestBody SkillUser skillUser) {

		return skillUserServiceImpl.createSkillUser(skillUser);
	}

	@PutMapping("/skillsusers/{id}")
	public SkillUser updateSkillUser(@PathVariable(name = "id") int id, @RequestBody SkillUser skillUser) {

		SkillUser selectedSkillUser = new SkillUser();
		SkillUser updatedSkillUser = new SkillUser();

		selectedSkillUser = skillUserServiceImpl.getSkillUserById(id);

		selectedSkillUser.setSkill(skillUser.getSkill());
		selectedSkillUser.setUser(skillUser.getUser());
		selectedSkillUser.setValidated(skillUser.isValidated());

		updatedSkillUser = skillUserServiceImpl.updateSkillUser(selectedSkillUser);

		return updatedSkillUser;
	}

	@DeleteMapping("/skillsusers/{id}")
	public void deleteSkillUser(@PathVariable(name = "id") int id) {

		skillUserServiceImpl.deleteSkillUser(id);
	}

	// Busca las SkillUser a partir de un usuario
	@GetMapping("/skillsusers/user/{userid}")
	public List<SkillUser> getAllSkillUserByUser(@PathVariable(name = "userid") int userid) {

		User user = userServiceImpl.getUserById(userid);

		return skillUserServiceImpl.getAllSkillUserByUser(user);
	}

	// Busca las SkillUser a partir de una skill
	@GetMapping("/skillsusers/skill/{skillid}")
	public List<SkillUser> getAllSkillUserBySkill(@PathVariable(name = "skillid") int skillid) {

		Skill skill = skillServiceImpl.getSkillById(skillid);

		return skillUserServiceImpl.getAllSkillUserBySkill(skill);
	}
	
	// Busca las SkillUser a partir de un usuario y una skill
	@GetMapping("/skillsusers/user/{userid}/skill/{skillid}")
	public List<SkillUser> getAllSkillUserByUserAndSkill(@PathVariable(name = "userid") int userid, @PathVariable(name = "skillid") int skillid) {
		
		User user = userServiceImpl.getUserById(userid);
		Skill skill = skillServiceImpl.getSkillById(skillid);
		
		return skillUserServiceImpl.getAllSkillUserByUserAndSkill(user, skill);
	}
}