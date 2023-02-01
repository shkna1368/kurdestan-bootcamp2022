package com.kurdestan.pushnotification.mqtt.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TopicMetricResponse {


    @JsonProperty("create_time")

    private Date createTime;

    @JsonProperty("metrics")

    private Metric metrics;


    @JsonProperty("topic")

    private String  topic;

}
