package de.telekom.sea3.webserver.view;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Persons;
import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URL;

//может создавать из джава объектов различные файлы
@RestController
public class PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        System.out.println("A person rest controller with person service (" + personService.toString() + ") is created: " + this.toString());
        this.personService = personService;
    }

    //URL:"http://localhost:8080/allpersons"
    /** @see URL: <a href="http://localhost:8080/json/persons/all">http://localhost:8080/json/persons/all</a> */
    @GetMapping("/json/persons/all")
    //@ResponseBody
    public Persons getAllPersons() {
        Persons persons = personService.getAllPersons();
//        String string = "{\n" +
//                "  \"persons\": [\n" +
//                "    {\n" +
//                "      \"id\": \"JSON_001\",\n" +
//                "      \"name\": \"JSON_Paul\",\n" +
//                "      \"surname\": \"JSON_Paulsen\",\n" +
//                "      \"salutation\": \"JSON_Mr\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"id\": \"JSON_002\",\n" +
//                "      \"name\":\"JSON_Paulina\",\n" +
//                "      \"surname\":\"JSON_Paulsen\",\n" +
//                "      \"salutation\":\"JSON_Mrs\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"id\": \"JSON_003\",\n" +
//                "      \"name\":\"JSON_Sam\",\n" +
//                "      \"surname\":\"JSON_Smith\",\n" +
//                "      \"salutation\":\"JSON_Mr\"\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//        return string;
        return persons;
    }

    //URL:"http://localhost:8080/allpersons"
    @GetMapping("/json/persons/size")
    //@ResponseBody
    public Size getSize() {
        return new Size(personService.getSize());
//        String string = String.format("{\n"
//                + "	\"size\": %d\n"
//                + "}",size);
//        return string;

    }

    @GetMapping("json/person/{id}")
    public Person getPerson(@PathVariable ("id") int id) {
        return personService.get(id);
    }

    @PostMapping("json/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.add(person);

    }
}
