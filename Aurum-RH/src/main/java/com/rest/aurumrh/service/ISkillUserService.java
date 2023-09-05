package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.SkillUser;

public interface ISkillUserService {

	public List<SkillUser> getAllSkillsUsers();

	public SkillUser getSkillUserById(int id);

	public SkillUser createSkillUser(SkillUser skillUser);

	public SkillUser updateSkillUser(SkillUser skillUser);

	public void deleteSkillUser(int id);
}