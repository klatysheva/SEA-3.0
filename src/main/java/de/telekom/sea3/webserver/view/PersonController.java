package de.telekom.sea3.webserver.view;

import de.telekom.sea3.webserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        System.out.println("A person controller with person service (" + personService.toString() + ") is created: " + this.toString());
        this.personService = personService;
    }
}
