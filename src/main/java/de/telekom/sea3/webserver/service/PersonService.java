package de.telekom.sea3.webserver.service;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Persons;
import de.telekom.sea3.webserver.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        System.out.println("A person service with person repository (" + personRepository.toString() + ") is created: " + this.toString());
        this.personRepository = personRepository;
    }

    public int getSize() {
        return personRepository.getSize();
    }

    public Persons getAllPersons() {
        return new Persons(personRepository.getAll());
    }

    public Person get(int id) {
        return new Person("001", "Mr" ,"New", "Person");
    }

    public Person add(Person person) {
        personRepository.add(person);
        System.out.println("Person is added!");
        return person;
    }

    public void remove(String id) {
        personRepository.remove(id);
        System.out.println("Person #" + id +" is deleted!");

    }
}
