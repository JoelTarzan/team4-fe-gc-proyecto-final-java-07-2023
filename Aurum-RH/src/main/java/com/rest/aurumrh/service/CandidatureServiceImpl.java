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

	@Override
	public List<Candidature> getAllCandidaturesASC() {
		
		return iCandidatureDAO.findAllByOrderByNameAsc();
	}

	@Override
	public List<Candidature> getAllCandidaturesDESC() {
		
		return iCandidatureDAO.findAllByOrderByNameDesc();
	}

	@Override
	public List<Candidature> getAllCandidaturesStartingWith(String letters) {
		
		return iCandidatureDAO.findByNameStartingWithIgnoreCase(letters);
	}

	@Override
	public List<Candidature> getAllCandidaturesByOrderOpen() {
		
		return iCandidatureDAO.findAllByOrderByStateDesc();
	}

	@Override
	public List<Candidature> getAllCandidaturesByOrderClose() {
		
		return iCandidatureDAO.findAllByOrderByStateAsc();
	}

	@Override
	public List<Candidature> getAllCandidaturesStartingWithByOrderOpen(String letters) {
		
		return iCandidatureDAO.findByNameStartingWithIgnoreCaseOrderByStateDesc(letters);
	}

	@Override
	public List<Candidature> getAllCandidaturesStartingWithByOrderClose(String letters) {
		
		return iCandidatureDAO.findByNameStartingWithIgnoreCaseOrderByStateAsc(letters);
	}

	@Override
	public List<Candidature> getAllCandidaturesOpen() {
		
		return iCandidatureDAO.findAllByStateTrue();
	}

	@Override
	public List<Candidature> getAllCandidaturesClose() {
		
		return iCandidatureDAO.findAllByStateFalse();
	}
}