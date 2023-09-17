package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.IOpenProcessDAO;
import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.OpenProcess;
import com.rest.aurumrh.dto.User;

@Service
public class OpenProcessServiceImpl implements IOpenProcessService {

	@Autowired
	IOpenProcessDAO iOpenProcessDAO;
	
	@Override
	public List<OpenProcess> getAllOpenProcesses() {
		
		return iOpenProcessDAO.findAll();
	}

	@Override
	public OpenProcess getOpenProcessById(int id) {
		
		return iOpenProcessDAO.findById(id).get();
	}

	@Override
	public OpenProcess createOpenProcess(OpenProcess openProcess) {
		
		return iOpenProcessDAO.save(openProcess);
	}

	@Override
	public OpenProcess updateOpenProcess(OpenProcess openProcess) {
		
		return iOpenProcessDAO.save(openProcess);
	}

	@Override
	public void deleteOpenProcess(int id) {
		
		iOpenProcessDAO.deleteById(id);
	}

	@Override
	public List<OpenProcess> getAllOpenProcessesByUser(User user) {
		
		return iOpenProcessDAO.findByUser(user);
	}

	@Override
	public List<OpenProcess> getAllOpenProcessesByDateAsc() {
		
		return iOpenProcessDAO.findAllByOrderByDateAsc();
	}

	@Override
	public List<OpenProcess> getAllOpenProcessesByDateDesc() {
		
		return iOpenProcessDAO.findAllByOrderByDateDesc();
	}
	
	@Override
	public List<OpenProcess> getAllOpenProcessesByUserByDateAsc(User user) {
		
		return iOpenProcessDAO.findByUserOrderByDateAsc(user);
	}

	@Override
	public List<OpenProcess> getAllOpenProcessesByUserByDateDesc(User user) {
		
		return iOpenProcessDAO.findByUserOrderByDateDesc(user);
	}

	@Override
	public List<OpenProcess> getAllOpenProcessesByCandidatureAndUserByDateAsc(Candidature candidature, User user) {
		
		return iOpenProcessDAO.findByCandidatureAndUserOrderByDateAsc(candidature, user);
	}

	@Override
	public List<OpenProcess> getAllOpenProcessesByCandidatureAndUserByDateDesc(Candidature candidature, User user) {
		
		return iOpenProcessDAO.findByCandidatureAndUserOrderByDateDesc(candidature, user);
	}
}