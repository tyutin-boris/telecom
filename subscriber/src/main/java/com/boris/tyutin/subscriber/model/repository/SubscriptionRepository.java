package com.boris.tyutin.subscriber.model.repository;

import com.boris.tyutin.subscriber.model.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
