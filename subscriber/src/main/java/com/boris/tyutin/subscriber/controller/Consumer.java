package com.boris.tyutin.subscriber.controller;

import com.boris.tyutin.subscriber.controller.request.MessageRequest;
import com.boris.tyutin.subscriber.model.entity.Action;
import com.boris.tyutin.subscriber.model.entity.MessageDTO;
import com.boris.tyutin.subscriber.model.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer {

    private final MessageService messageService;

    public Consumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public ResponseEntity<String> saveMessage(@RequestBody MessageRequest req) {
        System.out.println();
        messageService.save(MessageDTO.builder()
                .id(req.getId())
                .msisdn(req.getMsisdn())
                .action(Action.getAction(req.getAction()))
                .timestamp(req.getTimestamp())
                .build());
        return ResponseEntity.ok("");
    }
}
