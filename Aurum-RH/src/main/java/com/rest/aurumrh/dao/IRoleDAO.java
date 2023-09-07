package com.rest.aurumrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Role;


public interface IRoleDAO extends JpaRepository<Role, Integer> {
	
		public Role findByName(String name);
	
}
 