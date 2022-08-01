package com.kurdestan.bootcamp.liquibase;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item,Long> {


}
