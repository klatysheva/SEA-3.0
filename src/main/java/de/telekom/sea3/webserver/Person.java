package de.telekom.sea3.webserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//create a new person
@Component
public class Person {

    private Dog dog;
    private Cat cat;

    @Autowired
    public Person(Dog dog, Cat cat) {
        this.dog = dog;
        this.cat = cat;
        System.out.println("A person is created! Has a dog: " + (this.dog != null) + ", has a cat: " + (this.cat != null) + ".");
        System.out.println(this.dog.toString());
        System.out.println(this.cat.toString());
    }
}
