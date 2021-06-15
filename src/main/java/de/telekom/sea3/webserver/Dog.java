package de.telekom.sea3.webserver;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    private String name;
    public Dog() {
        System.out.println("A dog " + this + "is created!");
    }
    public Dog(String name) {
        this.name = name;
        System.out.println("A dog " + name + "is created!");
    }

}
