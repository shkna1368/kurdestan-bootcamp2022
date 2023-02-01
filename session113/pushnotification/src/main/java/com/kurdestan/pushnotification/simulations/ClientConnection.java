package com.kurdestan.pushnotification.simulations;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientConnection {


private List<Subscriber> subscriberlist;
    public void createMqttConnections(int connectionNumber) {

        subscriberlist=new ArrayList<>();

        System.out.println("start createMqttConnections ");


        for (int i=0;i<connectionNumber ;i++){
            System.out.println("connection"+i);





try {
    Subscriber s = new Subscriber("tcp://127.0.0.1",1883,"Username"+i,"Password"+i,"Phone"+i,"topic"+i);
subscriberlist.add(s);
}catch (Exception e){

    System.out.println(e);
}



        }

        System.out.println("start createMqttConnections ");

    }

    public List<Subscriber> getSubscriberlist() {
        return subscriberlist;
    }
}
