/*
package ir.fanap.pushnotification.simulations;

import ir.fanap.pushnotification.clients.Client;
import ir.fanap.pushnotification.clients.ClientRepository;
import ir.fanap.pushnotification.mqtt.MqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ClientSubscribe {
    @Autowired
    MqttClient mqttClient;




    public void createUserSubscribe(){






        System.out.println("start subscription creation ");

            for (int i=0;i<50;i++) {

              var client=  mqttClient.getClientByUsername("Username"+i,1l,1l);
                String topic="topic"+i;
                Map<String, Object> data=new HashMap<>();
                data.put("topic",topic);
                data.put("qos",0);

                mqttClient.subscribe(client.getData().get(0).getClientId(),data);
                System.out.println(i);



            }

        System.out.println("end subscription creation ");


        }



    }





*/
