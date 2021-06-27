package com.boris.tyutin.publisher.service;

import com.boris.tyutin.publisher.entity.Action;
import com.boris.tyutin.publisher.entity.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageService {

    private static final AtomicLong id = new AtomicLong();

    public synchronized static MessageDTO getMessage() {
        return MessageDTO.builder()
                .id(id.incrementAndGet())
                .msisdn(getMsisdn())
                .action(getAction())
                .timestamp((int) (System.currentTimeMillis() / 1000L))
                .build();
    }

    private static Action getAction() {
        return new Random().nextBoolean() ? Action.SUBSCRIPTION : Action.PURCHASE;
    }

    private static int getMsisdn() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
