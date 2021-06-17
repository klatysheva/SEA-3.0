package de.telekom.sea3.webserver.repo;

import de.telekom.sea3.webserver.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private List<Person> persons = new ArrayList<Person>();

    public PersonRepository() {
        System.out.println("A person repository is created: " + this.toString());
    }

    public int getSize() {
        return persons.size();
    }

    public boolean add(Person person) {
        return persons.add(person);
    }

    public List<Person> getAll() {
        return persons;
    }

    public void remove(String id) {
        persons.remove(Integer.parseInt(id)-1);
//        for (Person p : persons) {
//            if (p.getId().equals(id)) {
//                persons.remove(id);
//                return true;
//            }
//        }
//        return false;
    }
}
