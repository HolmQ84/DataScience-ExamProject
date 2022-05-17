package ds.front.Neo4J.controllers;

import ds.front.Neo4J.model.Person;
import ds.front.Neo4J.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static PersonRepository personRepository;

    public PersonController() {
    }

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Iterable<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{name}")
    public Person getPersonByName(@PathVariable String name) {
        return personRepository.getPersonByName(name);
    }

    @GetMapping("/search/{name}")
    public Iterable<Person> findPersonByNameLike(@PathVariable String name) {
        return personRepository.findPersonByNameLike(name);
    }

    @GetMapping("/actanddirect")
    public List<Person> getPersonsWhoActAndDirect() {
        return personRepository.getPersonsWhoActAndDirect();
    }
}
