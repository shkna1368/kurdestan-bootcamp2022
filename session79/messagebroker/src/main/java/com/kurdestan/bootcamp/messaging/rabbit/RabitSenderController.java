package com.kurdestan.bootcamp.messaging.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RabitSenderController {
@Autowired
    RabbitTemplate rabbitTemplate;
@Autowired
    Binding binding;

@GetMapping(value = "/send/{msg}")
@ResponseStatus(code = HttpStatus.OK)
public String send(@PathVariable("msg") final String message) {
        rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), message);
        return "Great!! your message is sent";
        }
        }