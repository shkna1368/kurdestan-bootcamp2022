package com.kurdestan.pushnotification.mqtt.response;

import lombok.Data;

@Data
public class SubscribeResponse {


    //{"clientid":"21674892745878","nl":0,"node":"emqx@127.0.0.1","qos":0,"rap":0,"rh":0,"topic":"car"}

    private String clientId;
    private Long nl;
    private String node;

    private int qos;
    private Long rap;
    private Long rh;
    private String topic;
}
