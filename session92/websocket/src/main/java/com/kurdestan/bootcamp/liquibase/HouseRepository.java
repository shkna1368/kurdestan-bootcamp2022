package com.kurdestan.bootcamp.liquibase;

import com.kurdestan.bootcamp.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HouseRepository extends PagingAndSortingRepository<House,Long> {


}
