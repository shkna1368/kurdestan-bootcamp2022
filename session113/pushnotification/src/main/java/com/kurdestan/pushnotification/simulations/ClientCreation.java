package com.kurdestan.pushnotification.simulations;

import com.kurdestan.pushnotification.clients.Client;
import com.kurdestan.pushnotification.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientCreation {
    @Autowired
    ClientRepository clientRepository;




    public void createUser(int connectionNumbers){
        System.out.println("start user creation ");
        if (clientRepository.count()<20){

            for (int i=0;i<connectionNumbers;i++) {
                System.out.println(i);
                Client client = new Client();
client.setFirebaseId(String.valueOf(i));
client.setName("clientName"+i);
client.setFamily("clientFamily"+i);
client.setPhone("Phone"+i);
client.setPassword("Password"+i);
client.setUserName("Username"+i);
client.setEmail("Email"+i);

clientRepository.save(client);

            }


        }

        System.out.println("end of client creation");


    }




}
