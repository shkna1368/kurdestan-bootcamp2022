package com.kurdestan.pushnotification.mqtt;


import com.kurdestan.pushnotification.mqtt.response.ClientSearchResponse;
import com.kurdestan.pushnotification.mqtt.response.SubscribeResponse;
import com.kurdestan.pushnotification.mqtt.response.TopicMetricResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(name = "emqx", url = "http://localhost:18083/api/v5", configuration = FeignConfig.class)
public interface MqttClient {

    @PostMapping(value = "/mqtt/topic_metrics")
    //@Headers({"Content-Type: application/json"})
    TopicMetricResponse createTopic(@RequestBody Map<String,String> data);

 @GetMapping (value = "/mqtt/topic_metrics")
   @Headers({"Content-Type: application/json"})
 List<TopicMetricResponse> getTopics();

    @GetMapping (value = "/clients?page={page}&limit={limit}&username={userName}")
    @Headers({"Content-Type: application/json"})
    ClientSearchResponse getClientByUsername(@PathVariable(name = "userName") String UserName, @PathVariable(name = "page") Long page, @PathVariable(name = "limit") Long limit);


    //http://localhost:18083/api/v5/clients/21674892745878/subscribe
    @PostMapping(value = "/clients/{clientId}/subscribe")
        //@Headers({"Content-Type: application/json"})
    SubscribeResponse subscribe(@PathVariable(name = "clientId") String clientId, @RequestBody Map<String,Object> data);

    //http://localhost:18083/api/v5/clients/21674892745878/subscribe
    @GetMapping(value = "/clients/{clientId}/subscriptions")
    //@Headers({"Content-Type: application/json"})
    List<SubscribeResponse> subscriptions(@PathVariable(name = "clientId") String clientId);




/*    @GetMapping(value = "/publish/{topicName}")
    void publish(String topic,String message);

    @GetMapping(value = "/checkUserAvailabilityByClientId/{clientId}")
    boolean checkUserAvailabilityByClientId(String clientId);


    @GetMapping(value = "/checkUserAvailabilityByUserName/{userName}")
    boolean checkUserAvailabilityByUserName(String userName);*/
}
