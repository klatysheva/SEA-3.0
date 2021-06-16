package de.telekom.sea3.webserver.view;

import de.telekom.sea3.webserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public String getSize() {
        //int -> String options:
        //String string1 = Integer.toString(personService.getSize());
        //String string2 = String.valueOf(personService.getSize());
        //String string3 = "" + personService.getSize();
        //String string4 = String.format("%d", personService.getSize());
        String string5 = String.format(HTMLTEMPLATE, personService.getSize());
        return string5;
    }

}
