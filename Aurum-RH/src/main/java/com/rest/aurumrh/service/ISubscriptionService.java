package com.rest.aurumrh.service;

import java.util.List;

import com.rest.aurumrh.dto.Subscription;

public interface ISubscriptionService {

	public List<Subscription> getAllSubscriptions();
	
	public Subscription getSubscriptionById(int id);
	
	public Subscription createSubscription(Subscription subscription);
	
	public Subscription updateSubscription(Subscription subscription);
	
	public void deleteSubscription(int id);
}