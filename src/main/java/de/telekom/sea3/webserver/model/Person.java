package de.telekom.sea3.webserver.model;

import javax.persistence.*;

@Entity
@Table(name="persons")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private Long version;

    //@Enumerated(EnumType.ORDINAL/STRING)
    @Column
    private String salutation;

    @Column
    private String firstname;

    @Column
    private String lastname;

//    @Column
//    private Date dob;

    public Person(long id, String salutation, String lastname, String firstname) {
        this.id = id;
        this.salutation = salutation;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Person(String salutation, String lastname, String firstname) {
        this.id =-1;
        this.salutation = salutation;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Person() {
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

    public void setId(long id) {
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

    public long getId() {
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
