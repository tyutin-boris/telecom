package com.boris.tyutin.subscriber.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private long id;
    private long msisdn;
    private Action action;
    private int timestamp;
}