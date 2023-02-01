package com.kurdestan.pushnotification.mqtt.response;

import lombok.Data;

@Data
public class Topic {



    private int qos;
    private String topic;


}
