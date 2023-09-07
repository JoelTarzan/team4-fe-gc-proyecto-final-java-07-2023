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

import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.OpenProcess;
import com.rest.aurumrh.dto.User;
import com.rest.aurumrh.service.CandidatureServiceImpl;
import com.rest.aurumrh.service.OpenProcessServiceImpl;
import com.rest.aurumrh.service.UserServiceImpl;

@RestController
public class OpenProcessController {

	@Autowired
	OpenProcessServiceImpl openProcessServiceImpl;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	CandidatureServiceImpl candidatureServiceImpl;

	@GetMapping("/openprocesses")
	public List<OpenProcess> getAllOpenProcesses() {
		
		return openProcessServiceImpl.getAllOpenProcesses();
	}
	
	@GetMapping("/openprocesses/{id}")
	public OpenProcess getOpenProcessById(@PathVariable(name = "id") int id) {
		
		return openProcessServiceImpl.getOpenProcessById(id);
	}
	
	@PostMapping("/openprocesses")
	public OpenProcess createOpenProcess(@RequestBody OpenProcess openProcess) {
		
		return openProcessServiceImpl.createOpenProcess(openProcess);
	}
	
	@PutMapping("/openprocesses/{id}")
	public OpenProcess updateOpenProcess(@PathVariable(name = "id") int id, @RequestBody OpenProcess openProcess) {
		
		OpenProcess selectedOpenProcess = new OpenProcess();
		OpenProcess updatedOpenProcess = new OpenProcess();
		
		selectedOpenProcess = openProcessServiceImpl.getOpenProcessById(id);
		
		selectedOpenProcess.setName(openProcess.getName());
		selectedOpenProcess.setDate(openProcess.getDate());
		selectedOpenProcess.setOpen(openProcess.isOpen());
		selectedOpenProcess.setDate(openProcess.getDate());
		selectedOpenProcess.setUser(openProcess.getUser());
		selectedOpenProcess.setCandidature(openProcess.getCandidature());
		
		updatedOpenProcess = openProcessServiceImpl.updateOpenProcess(selectedOpenProcess);
		
		return updatedOpenProcess;
	}
	
	@DeleteMapping("/openprocesses/{id}")
	public void deleteOpenProcess(@PathVariable(name = "id") int id) {
		
		openProcessServiceImpl.deleteOpenProcess(id);
	}
	
	@GetMapping("/openprocesses/user/{id}")
	public List<OpenProcess> getAllOpenProcessesByUser(@PathVariable(name = "id") int id) {
		
		User user = userServiceImpl.getUserById(id);
		
		return openProcessServiceImpl.getAllOpenProcessesByUser(user);
	}
	
	@GetMapping("/openprocesses/date-asc")
	public List<OpenProcess> getAllOpenProcessesByDateAsc() {
		
		return openProcessServiceImpl.getAllOpenProcessesByDateAsc();
	}
	
	@GetMapping("/openprocesses/date-desc")
	public List<OpenProcess> getAllOpenProcessesByDateDesc() {
		
		return openProcessServiceImpl.getAllOpenProcessesByDateDesc();
	}
	
	@GetMapping("/openprocesses/candidature/{candidatureid}/user/{userid}/date-asc")
	public List<OpenProcess> getAllOpenProcessesByCandidatureAndUserByDateAsc(@PathVariable(name = "candidatureid") int candidatureId,
		    @PathVariable(name = "userid") int userId) {
		
		Candidature candidature = candidatureServiceImpl.getCandidatureById(candidatureId);
		
	    User user = userServiceImpl.getUserById(userId);
		
		return openProcessServiceImpl.getAllOpenProcessesByCandidatureAndUserByDateAsc(candidature, user);
	}
	
	@GetMapping("/openprocesses/candidature/{candidatureid}/user/{userid}/date-desc")
	public List<OpenProcess> getAllOpenProcessesByCandidatureAndUserByDateDesc(@PathVariable(name = "candidatureid") int candidatureId,
		    @PathVariable(name = "userid") int userId) {
		
		Candidature candidature = candidatureServiceImpl.getCandidatureById(candidatureId);
		
	    User user = userServiceImpl.getUserById(userId);
		
		return openProcessServiceImpl.getAllOpenProcessesByCandidatureAndUserByDateDesc(candidature, user);
	}
	
	
}