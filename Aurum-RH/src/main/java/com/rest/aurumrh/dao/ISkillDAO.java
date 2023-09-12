package com.rest.aurumrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Role;
import com.rest.aurumrh.dto.Skill;

public interface ISkillDAO extends JpaRepository<Skill, Integer> {
	
	//Metodo custom Busca por nombre
	public Skill findByName(String name);
}