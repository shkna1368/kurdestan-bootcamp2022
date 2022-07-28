package krd.kurdestanbootcamp.mongo.repo;

import krd.kurdestanbootcamp.mongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {




}
