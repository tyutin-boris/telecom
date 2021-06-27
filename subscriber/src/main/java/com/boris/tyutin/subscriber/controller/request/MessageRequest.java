package com.boris.tyutin.subscriber.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private long id;
    private long msisdn;
    private String action;
    private LocalDateTime timestamp;
}
