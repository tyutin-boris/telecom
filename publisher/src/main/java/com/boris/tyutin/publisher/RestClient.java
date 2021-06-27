package com.boris.tyutin.publisher;

import com.boris.tyutin.publisher.entity.MessageDTO;
import com.boris.tyutin.publisher.service.MessageService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    private static final String URL = "http://localhost:8080/messages";

    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        MessageDTO message = MessageService.getMessage();
        sendMessage(message);
    }

    public static void sendMessage(MessageDTO messageDTO) {
        restTemplate.postForEntity(URL, messageDTO, MessageDTO.class);
    }
}
