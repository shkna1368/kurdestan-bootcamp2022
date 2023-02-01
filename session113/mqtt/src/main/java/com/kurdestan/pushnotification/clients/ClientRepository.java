package com.kurdestan.pushnotification.clients;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {

Optional<Client> findByUserName(String username);
Optional<Client> findByPhone(String phone);

}
