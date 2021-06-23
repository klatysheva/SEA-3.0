package de.telekom.sea3.webserver.view;

import de.telekom.sea3.webserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonHtmlController {
    private static final String HTMLTEMPLATE = "<!DOCTYPE html>\n" +
            "<html lang='de''>\n" +
            "  <head>\n" +
            "    <link rel='shortcut icon' type='image/x-icon' href='images/T.ico'>\n" +
            "    <meta charset='utf-8'>\n" +
            "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
            "    <title>Titel</title>\n" +
            "  </head>\n" +
            "  <body>size: %d </body>\n" +
            "</html>";

    private PersonService personService;

    @Autowired
    public PersonHtmlController(PersonService personService) {
        System.out.println("A person controller with person service (" + personService.toString() + ") is created: " + this.toString());
        this.personService = personService;
    }

    //URL:"http://localhost:8080/size"
    @GetMapping("/size")
    public String getSize(Model model) {
        model.addAttribute("size", personService.count());
        return "size";
    }

    @GetMapping("/persons")
    public String getPersons (Model model)  {
        model.addAttribute("count", personService.count());
        return "persons";
    }

    //URL:"http://localhost:8080/count"
    @GetMapping("/count")
    public String getCount(Model model) {
        model.addAttribute("count", personService.count());
        return "count";
    }

//  Quest 755 "Spring 03 : Thymeleaf"
    @GetMapping("/quest755")
    public String quest(Model model) {
        model.addAttribute("name", "Kseniia");
        return "quest";
    }

}
