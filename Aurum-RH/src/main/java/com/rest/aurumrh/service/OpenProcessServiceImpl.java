package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.IOpenProcessDAO;
import com.rest.aurumrh.dto.OpenProcess;

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
}