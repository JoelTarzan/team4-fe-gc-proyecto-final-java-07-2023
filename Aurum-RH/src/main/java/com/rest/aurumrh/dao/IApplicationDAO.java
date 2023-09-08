package com.rest.aurumrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Application;
import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.User;

public interface IApplicationDAO extends JpaRepository<Application, Integer> {
	
	//Buscar por usuario
	public List<Application> findAllByUser(User user);
	
	//Buscar por Candidatura
	public List<Application> findAllByCandidature(Candidature candidature);
	
	//Buscar por Usuario y Candidatura
	public Application findAllByUserAndCandidature(User user, Candidature candidature);

}