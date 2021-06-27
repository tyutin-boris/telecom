package com.boris.tyutin.publisher.service;

import com.boris.tyutin.publisher.entity.Action;
import com.boris.tyutin.publisher.entity.MessageDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class MessageService {

    private static volatile long id = 0;

    public synchronized static MessageDTO getMessage() {

        MessageDTO messageDTO = MessageDTO.builder()
                .id(id)
                .msisdn(getMsisdn())
                .action(getAction())
                .timestamp(LocalDateTime.now())
                .build();
        id++;
        return messageDTO;
    }

    private static Action getAction() {
        return new Random().nextInt(2) == 0
                ? Action.SUBSCRIPTION : Action.PURCHASE;
    }

    private static int getMsisdn() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
