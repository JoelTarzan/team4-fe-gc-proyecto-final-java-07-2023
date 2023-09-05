package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.OpenProcess;

public interface IOpenProcessService {

	public List<OpenProcess> getAllOpenProcesses();

	public OpenProcess getOpenProcessById(int id);

	public OpenProcess createOpenProcess(OpenProcess openProcess);

	public OpenProcess updateOpenProcess(OpenProcess openProcess);

	public void deleteOpenProcess(int id);
}