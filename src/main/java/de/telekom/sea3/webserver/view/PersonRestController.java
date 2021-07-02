package de.telekom.sea3.webserver.view;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Persons;
import de.telekom.sea3.webserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.Optional;

@RestController
public class PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/json/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/json/person")
    public Person updatePerson(@RequestBody Person person) {
        return personService.save(person);
    }

    //URL:"http://localhost:8080/json/persons/all"
    /** @see URL: <a href="http://localhost:8080/json/persons/all">http://localhost:8080/json/persons/all</a> */
    @GetMapping("/json/persons/all")
    public Persons getAllPersons() {
        Persons persons = personService.getAllPersons();
        return persons;
    }

    //URL:"http://localhost:8080/json/persons/size"
    @GetMapping("/json/persons/size")
    public long getSize() {
        return personService.count();

    }

    //URL:"http://localhost:8080/json/person/id"
    @GetMapping("/json/person/{id}")
    public Optional<Person> getPerson(@PathVariable ("id") long id) {
        return personService.findById(id);
    }

    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable ("id") long id) {
        personService.deleteById(id);
        return "redirect:/persons";
    }

    //URL:"http://localhost:8080/json/persons/deleteall"
    @DeleteMapping("/json/persons/deleteall")
    public void deleteAllPersons() {
        personService.deleteAll();
    }


    //http://localhost:8080/json/persons/search?text=Adam
    @GetMapping("/json/persons/search")
    public Persons searchByText(@RequestParam (name = "text", required = false) String text) {
        Persons persons = personService.selectPersons(text);
        return persons;
    }
}

