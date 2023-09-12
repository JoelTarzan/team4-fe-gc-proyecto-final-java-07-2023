package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.OpenProcess;
import com.rest.aurumrh.dto.Subscription;
import com.rest.aurumrh.dto.User;

public interface ISubscriptionService {

	public List<Subscription> getAllSubscriptions();
	
	public Subscription getSubscriptionById(int id);
	
	public Subscription createSubscription(Subscription subscription);
	
	public Subscription updateSubscription(Subscription subscription);
	
	public void deleteSubscription(int id);
	
	// Subscriptions de cada proceso abierto
	public List<Subscription> getAllSubscriptionsByOpenProcess(OpenProcess openProcess);
	
	// Subscriptions de cada user
	public List<Subscription> getAllSubscriptionsByUser(User user);
}