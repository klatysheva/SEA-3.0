package de.telekom.sea3.webserver.model;

import javax.persistence.*;
import java.sql.Date;

//indicates that this object will be managed by Spring Data and that its attributes will be converted into columns of DB tables
@Entity
@Table(name="persons")

public class Person {

    // indicates that the attribute should be used as the primary key in the table corresponding to the entity:
    @Id
    //indicates that the value of the id will be generated automatically, and incrementally, upon insertion into the database:
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

    @Column
    private Date dob;

    //Default constructor, getters and setters to make JPA happy.
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

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSalutation() { return salutation; }

    public long getId() {
        return id;
    }

    public Date getDob() {
        return dob;
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
        return ((person.getId() == this.getId()) && person.getFirstname().equals(this.firstname) && person.getLastname().equals(this.lastname)
                && person.getSalutation().equals(this.salutation) && person.getDob().equals(this.dob));
    }
}
