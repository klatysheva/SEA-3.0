package de.telekom.sea3.webserver.service;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Persons;
import de.telekom.sea3.webserver.repo.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private PersonsRepository personRepository;

    @Autowired
    public PersonService(PersonsRepository personRepository) {
        System.out.println("A person service with person repository (" + personRepository.toString() + ") is created: " + this);
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    public long count() {
        return personRepository.count();
    }

    public Persons getAllPersons(){
        Persons ps = new Persons();
        for (Person p : personRepository.findAll()) {
            ps.getPersons().add(p);
        }
        return ps;
    }

    public Optional<Person> findById(long id) {
        return personRepository.findById(id);
    }

    public void deleteById(Long aLong) {
        personRepository.deleteById(aLong);
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }

    public Persons selectPersons(String text) {
        Persons ps = new Persons();
        for (Person p : personRepository.selectPersons(text)) {
            ps.getPersons().add(p);
        }
        return ps;
    }
}
