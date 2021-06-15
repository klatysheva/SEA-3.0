package de.telekom.sea3.webserver.model;

import java.util.Scanner;

import static de.telekom.sea3.webserver.model.Color.*;

public class Person {
    //private long id = -1;
    private Salutation salutation;
    private String firstname;
    private String lastname;

    public Person() {
    }

//    public Person(String firstname, String lastname) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//    }

//    public Person(long id, Salutation salutation, String lastname, String firstname) {
//        this.id = id;
//        this.salutation = salutation;
//        this.firstname = firstname;
//        this.lastname = lastname;
//    }

    public Person(Salutation salutation, String lastname, String firstname) {
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

    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
    }

    public boolean setSalutation(Scanner scanner) {
        Salutation salutation;
        System.out.println("Enter salutation: ");
        String salutationString = scanner.nextLine();
        if (Salutation.isSalutationStringValue(salutationString)) {
            salutation = Salutation.fromString(salutationString);
            this.salutation = salutation;
            return true;
        }
        else {
            System.out.println(ANSI_RED + "This value is not allowed for salutation.");
            System.out.print("Allowed values: ");
            Salutation.showAllowedValues();
            System.out.print(ANSI_RESET);
            return false;
        }
    }

    //public void setId(long id) {
    //    this.id = id;
    //}

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    //public long getId() {
        //return id;
    //}

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
        return (/*(person.getId() == this.getId()) && */person.getFirstname().equals(this.firstname) && person.getLastname().equals(this.lastname) && person.getSalutation().equals(this.salutation));
    }
}
