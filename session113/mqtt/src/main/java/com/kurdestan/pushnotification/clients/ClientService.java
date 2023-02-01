package com.kurdestan.pushnotification.clients;

import java.util.List;

public interface ClientService {

    Client register(Client client);
    Client update(Client client);
    Client updateFirebaseId(Long userId,String firebaseId);
    Client getById(Long id);
    Client getByPhone(String phone);
    Client getByUserName(String userName);
    List<Client> getAll();

}
