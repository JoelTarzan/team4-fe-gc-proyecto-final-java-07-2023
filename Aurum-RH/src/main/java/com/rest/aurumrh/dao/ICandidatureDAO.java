package com.rest.aurumrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Candidature;

public interface ICandidatureDAO extends JpaRepository<Candidature, Integer> {

	// Candidaturas ordenadas alfabeticamente de forma ASC
	public List<Candidature> findAllByOrderByNameAsc();
	
	// Candidaturas ordenadas alfabeticamente de forma DESC
	public List<Candidature> findAllByOrderByNameDesc();
	
	// Buscar candidaturas que empiecen por X letras
	public List<Candidature> findByNameStartingWithIgnoreCase(String letters);
	
	// Candidaturas ordenadas por estado abierto
	public List<Candidature> findAllByOrderByStateDesc();
	
	// Candidaturas ordenadas por estado cerrado
	public List<Candidature> findAllByOrderByStateAsc();
	
	// Buscar candidaturas que empiecen por X letras ordenadas por estado abierto
	public List<Candidature> findByNameStartingWithIgnoreCaseOrderByStateDesc(String letters);
	
	// Buscar candidaturas que empiecen por X letras ordenadas por estado cerrado
	public List<Candidature> findByNameStartingWithIgnoreCaseOrderByStateAsc(String letters);
	
	// Candidaturas abiertas
	public List<Candidature> findAllByStateTrue();
	
	// Candidaturas cerradas
	public List<Candidature> findAllByStateFalse();
}