package com.kurdestan.pushnotification.simulations;


import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Commander {

    @Autowired
    ClientCreation clientCreation;

  /*  @Autowired
    ClientSubscribe clientSubscribe;*/


      @Autowired
    ClientConnection clientConnection;





    public void start() throws MqttException {
        int connectionsNumber=100;


        clientCreation.createUser(connectionsNumber);

        clientConnection.createMqttConnections(connectionsNumber);

  List<Subscriber> subscribers= clientConnection.getSubscriberlist();

        System.out.println("start sending messge ");

        for (int i=0;i<connectionsNumber;i++){
            System.out.println("send messgage "+"message"+i +"topic"+i);

    subscribers.get(i).sendMessage("message"+i,"topic"+i);

}
        System.out.println("end sending message ");



        //  clientSubscribe.createUserSubscribe();



    }
}
