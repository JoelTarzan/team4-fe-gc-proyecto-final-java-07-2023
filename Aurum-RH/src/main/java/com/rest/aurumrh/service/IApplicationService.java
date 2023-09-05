package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Application;

public interface IApplicationService {

	public List<Application> getAllApplications();

	public Application getApplicationById(int id);

	public Application createApplication(Application application);

	public Application updateApplication(Application application);

	public void deleteApplication(int id);
}