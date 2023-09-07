package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Candidature;

public interface ICandidatureService {

	public List<Candidature> getAllCandidatures();

	public Candidature getCandidatureById(int id);

	public Candidature createCandidature(Candidature candidature);

	public Candidature updateCandidature(Candidature candidature);

	public void deleteCandidature(int id);

	// Candidaturas ordenadas alfabeticamente de forma ASC
	public List<Candidature> getAllCandidaturesASC();

	// Candidaturas ordenadas alfabeticamente de forma DESC
	public List<Candidature> getAllCandidaturesDESC();

	// Buscar candidaturas que empiecen por X letras
	public List<Candidature> getAllCandidaturesStartingWith(String letters);

	// Candidaturas ordenadas por estado abierto
	public List<Candidature> getAllCandidaturesByOrderOpen();

	// Candidaturas ordenadas por estado cerrado
	public List<Candidature> getAllCandidaturesByOrderClose();

	// Buscar candidaturas que empiecen por X letras ordenadas por estado abierto
	public List<Candidature> getAllCandidaturesStartingWithByOrderOpen(String letters);

	// Buscar candidaturas que empiecen por X letras ordenadas por estado cerrado
	public List<Candidature> getAllCandidaturesStartingWithByOrderClose(String letters);

	// Candidaturas abiertas
	public List<Candidature> getAllCandidaturesOpen();

	// Candidaturas cerradas
	public List<Candidature> getAllCandidaturesClose();
}