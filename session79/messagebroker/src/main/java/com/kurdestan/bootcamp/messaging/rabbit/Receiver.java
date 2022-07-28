package com.kurdestan.bootcamp.messaging.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {


    @Autowired
    Queue qu;

    @RabbitListener(queues = "#{qu.getName()}")
    public void getMsg(final String message) {
        System.out.println("rabit recver:" +message);
    }
}