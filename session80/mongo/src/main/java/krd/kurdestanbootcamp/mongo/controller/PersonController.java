package krd.kurdestanbootcamp.mongo.controller;

import krd.kurdestanbootcamp.mongo.model.Person;
import krd.kurdestanbootcamp.mongo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("person")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;


    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.insertPersonData(person);
    }

    @GetMapping
    public Collection<Person> read() {
        return personService.getAllPersonInformation();
    }




    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") String id){
        personService.deletePersonUsingId(id);
    }




}
