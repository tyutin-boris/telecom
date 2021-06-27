package com.boris.tyutin.publisher;

import com.boris.tyutin.publisher.entity.MessageDTO;
import com.boris.tyutin.publisher.service.MessageService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.TimeUnit;

@Component
public class RestClient {

    private static final String URL = "http://localhost:8080/messages";

    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Runnable task = () -> {
            while (true) {
                MessageDTO message = MessageService.getMessage();
                sendMessage(message);
                try {
                    TimeUnit.SECONDS.sleep(15);
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Task interrupted", e);
                }
            }
        };
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(task));
        }
        threads.forEach(Thread::start);
    }

    public static void sendMessage(MessageDTO messageDTO) {
        restTemplate.postForEntity(URL, messageDTO, MessageDTO.class);
    }
}
