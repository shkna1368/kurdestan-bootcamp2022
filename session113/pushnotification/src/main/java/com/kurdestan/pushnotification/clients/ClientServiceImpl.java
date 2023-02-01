package com.kurdestan.pushnotification.clients;

import com.kurdestan.pushnotification.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    @Override
    public Client register(Client client) {

      var savedClient=  clientRepository.save(client);

      //make topic

        return clientRepository.save(savedClient);
    }

    @Override
    public Client update(Client client) {
      var lastSavedClientData= getById(client.getId());
      lastSavedClientData.setEmail(client.getEmail());
      lastSavedClientData.setFamily(client.getFamily());
      lastSavedClientData.setName(client.getName());
      lastSavedClientData.setPhone(client.getPhone());
      lastSavedClientData.setFirebaseId(client.getFirebaseId());

        return clientRepository.save(lastSavedClientData);
    }

    @Override
    public Client updateFirebaseId(Long userId,String firebaseId) {
   var lastSavedClient=  getById(userId);
   lastSavedClient.setFirebaseId(firebaseId);

        return clientRepository.save(lastSavedClient);
    }

    @Override
    public Client getById(Long id) {

        var optionalClient=clientRepository.findById(id);
if (!optionalClient.isPresent()){
    throw new NotFoundException("client not found");
}
        return optionalClient.get();
    }

    @Override
    public Client getByPhone(String phone) {
        var optionalClient=clientRepository.findByPhone(phone);
        if (!optionalClient.isPresent()){
            throw new NotFoundException("client not found with this phone");
        }
        return optionalClient.get();
    }

    @Override
    public Client getByUserName(String userName) {
        var optionalClient=clientRepository.findByPhone((userName));
        if (!optionalClient.isPresent()){
            throw new NotFoundException("client not found with this phone");
        }
        return optionalClient.get();
    }

    @Override
    public List<Client> getAll() {
        return (List<Client>) clientRepository.findAll();
    }
}
