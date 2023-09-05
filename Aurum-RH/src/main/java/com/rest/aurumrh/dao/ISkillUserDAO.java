package com.rest.aurumrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.SkillUser;


public interface ISkillUserDAO extends JpaRepository<SkillUser, Integer> {

}
