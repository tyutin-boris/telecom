package com.boris.tyutin.subscriber.model.service;

import com.boris.tyutin.subscriber.model.entity.Purchase;
import com.boris.tyutin.subscriber.model.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}
