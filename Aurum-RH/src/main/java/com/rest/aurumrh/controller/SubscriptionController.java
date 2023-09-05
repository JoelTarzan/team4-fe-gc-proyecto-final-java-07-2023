package com.rest.aurumrh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.aurumrh.dto.Subscription;
import com.rest.aurumrh.service.SubscriptionServiceImpl;

@RestController
public class SubscriptionController {

	@Autowired
	SubscriptionServiceImpl subscriptionServiceImpl;

	@GetMapping("/subscriptions")
	public List<Subscription> getAllSubscriptions() {

		return subscriptionServiceImpl.getAllSubscriptions();
	}

	@GetMapping("/subscriptions/{id}")
	public Subscription getSubscriptionById(@PathVariable(name = "id") int id) {

		return subscriptionServiceImpl.getSubscriptionById(id);
	}

	@PostMapping("/subscriptions")
	public Subscription createSubscription(@RequestBody Subscription subscription) {

		return subscriptionServiceImpl.createSubscription(subscription);
	}

	@PutMapping("/subscriptions/{id}")
	public Subscription updateSubscription(@PathVariable(name = "id") int id, @RequestBody Subscription subscription) {

		Subscription selectedSubscription = new Subscription();
		Subscription updatedSubscription = new Subscription();

		selectedSubscription = subscriptionServiceImpl.getSubscriptionById(id);

		selectedSubscription.setOpenProcess(subscription.getOpenProcess());
		selectedSubscription.setUser(subscription.getUser());

		updatedSubscription = subscriptionServiceImpl.updateSubscription(selectedSubscription);

		return updatedSubscription;
	}

	@DeleteMapping("/subscriptions/{id}")
	public void deleteSubscription(@PathVariable(name = "id") int id) {

		subscriptionServiceImpl.deleteSubscription(id);
	}
}