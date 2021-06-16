package de.telekom.sea3.webserver.model;

import java.util.Scanner;

import static de.telekom.sea3.webserver.model.Color.*;

public class Person {
    private String id;
    private String salutation;
    private String firstname;
    private String lastname;

    public Person(String id, String salutation, String lastname, String firstname) {
        this.id = id;
        this.salutation = salutation;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) // null check
        {
            return false;
        }
        if (this == obj) // self check
        {
            return true;
        }
        if (!(obj instanceof Person)) {// type check
            return false;
        }
        Person person = (Person) obj; // cast to Person
        return ((person.getId() == this.getId()) && person.getFirstname().equals(this.firstname) && person.getLastname().equals(this.lastname) && person.getSalutation().equals(this.salutation));
    }
}
