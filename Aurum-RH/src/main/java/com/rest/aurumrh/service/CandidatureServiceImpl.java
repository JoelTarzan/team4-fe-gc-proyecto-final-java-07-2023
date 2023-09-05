package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.ICandidatureDAO;
import com.rest.aurumrh.dto.Candidature;

@Service
public class CandidatureServiceImpl implements ICandidatureService {

	@Autowired
	ICandidatureDAO iCandidatureDAO;
	
	@Override
	public List<Candidature> getAllCandidatures() {
		
		return iCandidatureDAO.findAll();
	}

	@Override
	public Candidature getCandidatureById(int id) {
		
		return iCandidatureDAO.findById(id).get();
	}

	@Override
	public Candidature createCandidature(Candidature candidature) {
		
		return iCandidatureDAO.save(candidature);
	}

	@Override
	public Candidature updateCandidature(Candidature candidature) {
		
		return iCandidatureDAO.save(candidature);
	}

	@Override
	public void deleteCandidature(int id) {
		
		iCandidatureDAO.deleteById(id);
	}
}