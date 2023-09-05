package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Candidature;

public interface ICandidatureService {
	
public List<Candidature> getAllCandidatures();
	
	public Candidature getCandidatureById(int id);
	
	public Candidature createCandidature(Candidature candidature);
	
	public Candidature updateCandidature(Candidature candidature);
	
	public void deleteCandidature(int id);

}
