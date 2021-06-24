package de.telekom.sea3.webserver.model;

import java.util.ArrayList;
import java.util.List;

public class Persons {
    private List<Person> persons = new ArrayList<Person>();

    public Persons() {
    }

    public Persons(List<Person> all) {
        this.persons = all;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
