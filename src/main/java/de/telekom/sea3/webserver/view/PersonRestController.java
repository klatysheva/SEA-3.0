package de.telekom.sea3.webserver.view;

import de.telekom.sea3.webserver.model.Persons;
import de.telekom.sea3.webserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//может создавать из джава объектов различные файлы
@Controller
public class PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        System.out.println("A person rest controller with person service (" + personService.toString() + ") is created: " + this.toString());
        this.personService = personService;
    }

    //URL:"http://localhost:8080/allpersons"
    @GetMapping("/allpersons")
    @ResponseBody
    public String getAllPersons() {
        Persons persons = personService.getAllPersons();
        //persons.toJson();
        String string5 = "{\n" +
                "  \"persons\": [\n" +
                "    {\n" +
                "      \"id\": \"JSON_001\",\n" +
                "      \"name\": \"JSON_Paul\",\n" +
                "      \"surname\": \"JSON_Paulsen\",\n" +
                "      \"salutation\": \"JSON_Mr\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"JSON_002\",\n" +
                "      \"name\":\"JSON_Paulina\",\n" +
                "      \"surname\":\"JSON_Paulsen\",\n" +
                "      \"salutation\":\"JSON_Mrs\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"JSON_003\",\n" +
                "      \"name\":\"JSON_Sam\",\n" +
                "      \"surname\":\"JSON_Smith\",\n" +
                "      \"salutation\":\"JSON_Mr\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return string5;
    }
}