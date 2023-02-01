package com.kurdestan.pushnotification.mqtt.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClientSearchResponse {

    @JsonProperty("data")
    private List<ClientResponse> data;


    @JsonProperty("meta")
private Meta meta;



}
