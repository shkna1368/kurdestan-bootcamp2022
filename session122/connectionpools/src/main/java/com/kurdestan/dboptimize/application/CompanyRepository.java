package com.kurdestan.dboptimize.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

   // @EntityGraph(attributePaths = {"clientList"})
    Page<Company> findAll(Pageable pageable);
    List<Company> findAllByNameContaining(String name);

}
