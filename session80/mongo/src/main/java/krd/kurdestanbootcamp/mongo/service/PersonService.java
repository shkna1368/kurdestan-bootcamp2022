package krd.kurdestanbootcamp.mongo.service;

import krd.kurdestanbootcamp.mongo.repo.PersonRepository;
import krd.kurdestanbootcamp.mongo.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;


    public Person insertPersonData(Person person) {
        return personRepository.save(person);
    }

    public Collection<Person> getAllPersonInformation() {
        return personRepository.findAll();
    }



    public void deletePersonUsingId(String id) {
        personRepository.findById(id);
    }

}
