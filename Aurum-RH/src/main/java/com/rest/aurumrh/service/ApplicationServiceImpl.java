package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.IApplicationDAO;
import com.rest.aurumrh.dto.Application;
import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.User;

@Service
public class ApplicationServiceImpl implements IApplicationService{

	@Autowired
	IApplicationDAO iApplicationDAO;
	
	@Override
	public List<Application> getAllApplications() {
		
		return iApplicationDAO.findAll();
	}

	@Override
	public Application getApplicationById(int id) {
		
		return iApplicationDAO.findById(id).get();
	}

	@Override
	public Application createApplication(Application application) {
		
		return iApplicationDAO.save(application);
	}

	@Override
	public Application updateApplication(Application application) {
		
		return iApplicationDAO.save(application);
	}

	@Override
	public void deleteApplication(int id) {
		
		iApplicationDAO.deleteById(id);
		
	}

	@Override
	public List<Application> getApplicationByUser(User user) {
		
		return iApplicationDAO.findAllByUser(user);
	}

	@Override
	public List<Application> getApplicationByCandidature(Candidature candidature) {
		
		return iApplicationDAO.findAllByCandidature(candidature);
	}

	@Override
	public Application getApplicationByUserAndCandidature(User user, Candidature candidature) {
		
		return iApplicationDAO.findAllByUserAndCandidature(user, candidature);
	}
}
