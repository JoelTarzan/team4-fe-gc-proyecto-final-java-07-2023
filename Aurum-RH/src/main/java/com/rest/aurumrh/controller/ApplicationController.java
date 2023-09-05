package com.rest.aurumrh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.aurumrh.dto.Application;
import com.rest.aurumrh.service.ApplicationServiceImpl;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationServiceImpl applicationServiceImpl;
	
	@GetMapping("/applications")
	public List<Application> getAllApplications() {
		
		return applicationServiceImpl.getAllApplications();
	}
	
	@GetMapping("/applications/{id}")
	public Application getApplicationById(@PathVariable(name = "id") int id) {
		
		return applicationServiceImpl.getApplicationById(id);
	}
	
	@PostMapping("/applications")
	public Application createApplication(@RequestBody Application application) {
		
		return applicationServiceImpl.createApplication(application);
	}
	
	@PutMapping("/applications/{id}")
	public Application updateApplication(@PathVariable(name = "id") int id, @RequestBody Application application) {
		
		Application selectedApplication = new Application();
		Application updatedApplication = new Application();
		
		selectedApplication = applicationServiceImpl.getApplicationById(id);
		
		selectedApplication.setUser(application.getUser());
		selectedApplication.setCandidature(application.getCandidature());
		selectedApplication.setPhase(application.getPhase());
		
		updatedApplication = applicationServiceImpl.updateApplication(selectedApplication);
		
		return updatedApplication;
	}
	
	@DeleteMapping("/applications/{id}")
	public void deleteApplication(@PathVariable(name = "id") int id) {
		
		applicationServiceImpl.deleteApplication(id);
	}
}