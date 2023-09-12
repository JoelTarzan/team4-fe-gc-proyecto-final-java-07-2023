package com.rest.aurumrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.OpenProcess;
import com.rest.aurumrh.dto.Subscription;
import com.rest.aurumrh.dto.User;


public interface ISubscriptionDAO extends JpaRepository<Subscription, Integer> {
	
	public List<Subscription> findByOpenProcess(OpenProcess openProcess);
	
	public List<Subscription> findByUser(User user);
}
