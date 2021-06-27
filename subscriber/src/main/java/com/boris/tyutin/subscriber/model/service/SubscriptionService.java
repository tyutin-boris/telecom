package com.boris.tyutin.subscriber.model.service;

import com.boris.tyutin.subscriber.model.entity.Subscription;
import com.boris.tyutin.subscriber.model.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public void save(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }
}
