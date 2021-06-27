package com.boris.tyutin.subscriber.model.service;

import com.boris.tyutin.subscriber.model.entity.MessageDTO;
import com.boris.tyutin.subscriber.model.entity.Purchase;
import com.boris.tyutin.subscriber.model.entity.Subscription;
import com.boris.tyutin.subscriber.model.repository.PurchaseRepository;
import com.boris.tyutin.subscriber.model.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final PurchaseRepository purchaseRepository;
    private final SubscriptionRepository subscriptionRepository;

    public MessageService(PurchaseRepository purchaseRepository,
                          SubscriptionRepository subscriptionRepository) {
        this.purchaseRepository = purchaseRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public void save(MessageDTO message) {
        switch (message.getAction()) {
            case PURCHASE:
                purchaseRepository.save(Purchase.builder()
                        .id(message.getId())
                        .msisdn(message.getMsisdn())
                        .action(message.getAction().name())
                        .timestamp(message.getTimestamp()).build());
                break;

            case SUBSCRIPTION:
                subscriptionRepository.save(Subscription.builder()
                        .id(message.getId())
                        .msisdn(message.getMsisdn())
                        .action(message.getAction().name())
                        .timestamp(message.getTimestamp()).build());
                break;
        }
    }
}
