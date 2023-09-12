package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Application;
import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.User;

public interface IApplicationService {

	public List<Application> getAllApplications();

	public Application getApplicationById(int id);

	public Application createApplication(Application application);

	public Application updateApplication(Application application);

	public void deleteApplication(int id);
	
	// Buscar aplicaciones por medio de usuario (devuelve todas las aplicaciones de un usuario)
	public List<Application> getApplicationByUser(User user);
	
	// Buscar aplicaciones por medio de Candidatura (devuelve todas las aplicaciones de una candidatura)
	public List<Application> getApplicationByCandidature(Candidature candidature);
	
	// Busca aplicacion por medio de una Candidatura y un Usuario (devuelve la aplicacion que coincida con los 2 objetos)
	public Application getApplicationByUserAndCandidature(User user, Candidature candidature);
}