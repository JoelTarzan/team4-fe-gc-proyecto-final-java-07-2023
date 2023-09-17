package com.rest.aurumrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.Candidature;
import com.rest.aurumrh.dto.OpenProcess;
import com.rest.aurumrh.dto.User;

public interface IOpenProcessDAO extends JpaRepository<OpenProcess, Integer> {

	public List<OpenProcess> findByUser(User user);

	public List<OpenProcess> findAllByOrderByDateAsc();

	public List<OpenProcess> findAllByOrderByDateDesc();
	
	public List<OpenProcess> findByUserOrderByDateAsc(User user);
	
	public List<OpenProcess> findByUserOrderByDateDesc(User user);

	public List<OpenProcess> findByCandidatureAndUserOrderByDateAsc(Candidature candidature, User user);

	public List<OpenProcess> findByCandidatureAndUserOrderByDateDesc(Candidature candidature, User user);

}