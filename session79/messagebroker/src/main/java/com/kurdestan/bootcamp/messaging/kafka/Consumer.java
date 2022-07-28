package com.kurdestan.bootcamp.messaging.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {


    @KafkaListener(topics = "my-events", groupId = "group_id")
    public void consume(String message) throws IOException {
        System.out.println("consumed:"+message);
    }
}