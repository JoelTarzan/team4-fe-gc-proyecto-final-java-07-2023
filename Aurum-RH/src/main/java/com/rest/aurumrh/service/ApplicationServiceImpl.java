package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.IApplicationDAO;
import com.rest.aurumrh.dto.Application;

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

}
