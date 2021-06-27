package com.boris.tyutin.subscriber.model.repository;

import com.boris.tyutin.subscriber.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
