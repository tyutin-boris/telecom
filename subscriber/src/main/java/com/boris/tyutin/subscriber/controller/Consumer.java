package com.boris.tyutin.subscriber.controller;

import com.boris.tyutin.subscriber.controller.request.MessageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer {

    @PostMapping("/messages")
    public void saveMessage(@RequestBody MessageRequest req){
        System.out.println();
    }
}
