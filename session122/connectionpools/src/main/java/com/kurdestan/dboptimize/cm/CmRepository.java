package com.kurdestan.dboptimize.cm;

import com.kurdestan.dboptimize.application.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CmRepository extends CrudRepository<Cm, Long> {

   // @EntityGraph(attributePaths = {"clientList"})
    Page<Cm> findAll(Pageable pageable);
    List<Cm> findAllByNameContaining(String name);

}
