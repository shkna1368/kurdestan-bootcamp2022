package com.kurdestan.dboptimize.clients;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

@EntityGraph(attributePaths = {"company"})

Page<Client> findAll(Pageable pageable);

}
