package com.rest.aurumrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.SkillCandidature;

public interface ISkillCandidatureDAO extends JpaRepository<SkillCandidature, Integer> {

}