package com.boris.tyutin.publisher;

import com.boris.tyutin.publisher.entity.MessageDTO;
import com.boris.tyutin.publisher.service.MessageService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class RestClient {

    private static final String URL = "http://localhost:8080/messages";
    private static final int countThreads = 5;
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);
        executorService.submit(() -> {
            while (true) {
                MessageDTO message = MessageService.getMessage();
                sendMessage(message);
                sleeping(15);
            }
        });
    }

    private static void sleeping(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Task interrupted", e);
        }
    }

    public static void sendMessage(MessageDTO messageDTO) {
        restTemplate.postForEntity(URL, messageDTO, MessageDTO.class);
    }
}
