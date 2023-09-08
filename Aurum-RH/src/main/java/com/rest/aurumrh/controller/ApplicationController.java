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
import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.User;
import com.rest.aurumrh.service.ApplicationServiceImpl;
import com.rest.aurumrh.service.CandidatureServiceImpl;
import com.rest.aurumrh.service.UserServiceImpl;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationServiceImpl applicationServiceImpl;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	CandidatureServiceImpl candidatureServiceImpl;
	
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
	
	@GetMapping("/applications/user/{id}")
	public List<Application> getAllApplicationsByUser(@PathVariable(name = "id") int id) {
		
		User user = userServiceImpl.getUserById(id);
		
		return applicationServiceImpl.getApplicationByUser(user);
	}
	
	@GetMapping("/applications/candidature/{id}")
	public List<Application> getAllApplicationsByCandidature(@PathVariable(name = "id") int id) {
		
		Candidature candidature = candidatureServiceImpl.getCandidatureById(id);
		
		return applicationServiceImpl.getApplicationByCandidature(candidature);
	}
	
	@GetMapping("/applications/user/{userid}/candidature/{candidatureid}")
	public Application getAllApplicationsByCandidature(@PathVariable(name = "userid") int userid, @PathVariable(name = "candidatureid") int candidatureid) {
		
		User user = userServiceImpl.getUserById(userid);
		
		Candidature candidature = candidatureServiceImpl.getCandidatureById(candidatureid);
		
		return applicationServiceImpl.getApplicationByUserAndCandidature(user, candidature);
	}
}