package com.rest.aurumrh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.aurumrh.dto.OpenProcess;
import com.rest.aurumrh.dto.Subscription;


public interface ISubscriptionDAO extends JpaRepository<Subscription, Integer> {
	public List<Subscription> findByOpenProcessId(OpenProcess openProcess);
}
