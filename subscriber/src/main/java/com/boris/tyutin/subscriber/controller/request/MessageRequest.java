package com.boris.tyutin.subscriber.controller.request;


import java.time.LocalDateTime;

public class MessageRequest {
    private long id;
    private long msisdn;
    private String action;
    private LocalDateTime timestamp;
}
