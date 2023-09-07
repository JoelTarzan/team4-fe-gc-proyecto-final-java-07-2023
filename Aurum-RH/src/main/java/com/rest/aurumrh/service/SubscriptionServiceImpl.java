package com.rest.aurumrh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurumrh.dao.ISubscriptionDAO;
import com.rest.aurumrh.dto.OpenProcess;
import com.rest.aurumrh.dto.Subscription;
import com.rest.aurumrh.dto.User;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService{
	
	@Autowired
	ISubscriptionDAO iSubscriptionDAO;

	@Override
	public List<Subscription> getAllSubscriptions() {
		
		return iSubscriptionDAO.findAll();
	}

	@Override
	public Subscription getSubscriptionById(int id) {
		
		return iSubscriptionDAO.findById(id).get();
	}

	@Override
	public Subscription createSubscription(Subscription subscription) {
		
		return iSubscriptionDAO.save(subscription);
	}

	@Override
	public Subscription updateSubscription(Subscription subscription) {
		
		return iSubscriptionDAO.save(subscription);
	}

	@Override
	public void deleteSubscription(int id) {
		
		iSubscriptionDAO.deleteById(id);
		
	}

	@Override
	public List<Subscription> getAllSubscriptionsByOpenProcess(OpenProcess openProcess) {
		
		return iSubscriptionDAO.findByOpenProcess(openProcess);
	}

	@Override
	public List<Subscription> getAllSubscriptionsByUser(User user) {
		
		return iSubscriptionDAO.findByUser(user);
	}

}
