package de.telekom.sea3.webserver.service;

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

}
