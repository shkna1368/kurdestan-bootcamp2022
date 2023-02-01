package com.kurdestan.pushnotification;

import com.kurdestan.pushnotification.mqtt.MqttClient;
import com.kurdestan.pushnotification.simulations.Commander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.*;


@SpringBootApplication
@EnableFeignClients
public class Application implements ApplicationRunner {




    @Autowired
    Commander commander;



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

Date start=new Date();
commander.start();
        Date endDate=new Date();

        System.out.println("Start From "+start.toString());
        System.out.println("End in "+endDate.toString());

/*




        //test create topic
        String topic="topic"+System.currentTimeMillis();
        Map<String,String> data=new HashMap<>();
        data.put("topic",topic);
var x=mqttClient.createTopic(data);
        System.out.println(x);

       // test get topic
        List<TopicMetricResponse> topics = mqttClient.getTopics();
        System.out.println(topics);
*/

/*
        //get user by userName
var clientSearchresponse=mqttClient.getClientByUsername("m",1l,1l);
        System.out.println(clientSearchresponse);

        String topic="topic"+System.currentTimeMillis();
        Map<String, Object> data=new HashMap<>();
        data.put("topic",topic);
        data.put("qos",0);



String clientId=clientSearchresponse.getData().get(0).getClientId();
        //test subscrip in topic
        SubscribeResponse subscribeResponse= mqttClient.subscribe(clientId,data);
        System.out.println(subscribeResponse);




        //test subscrip in topic
        List<SubscribeResponse> subscribeResponses =      mqttClient.subscriptions(clientId);
        System.out.println(subscribeResponses);*/

  /*      String clientId="9148875059";
        Map<String, Object> data=new HashMap<>();
        data.put("topic","metopic");
        data.put("qos",0);
        //test subscrip in topic
        SubscribeResponse subscribeResponse= mqttClient.subscribe(clientId,data);
        System.out.println(subscribeResponse);*/





    }
}
