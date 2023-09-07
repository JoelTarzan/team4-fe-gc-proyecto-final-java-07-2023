package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.OpenProcess;
import com.rest.aurumrh.dto.User;

public interface IOpenProcessService {

	public List<OpenProcess> getAllOpenProcesses();

	public OpenProcess getOpenProcessById(int id);

	public OpenProcess createOpenProcess(OpenProcess openProcess);

	public OpenProcess updateOpenProcess(OpenProcess openProcess);

	public void deleteOpenProcess(int id);
	
	public List<OpenProcess> getAllOpenProcessesByUser(User user);
	
	public List<OpenProcess> getAllOpenProcessesByDateAsc();
	
	public List<OpenProcess> getAllOpenProcessesByDateDesc();
	
	public List<OpenProcess> getAllOpenProcessesByCandidatureAndUserByDateAsc(Candidature candidature, User user);
	
	public List<OpenProcess> getAllOpenProcessesByCandidatureAndUserByDateDesc(Candidature candidature, User user);
}