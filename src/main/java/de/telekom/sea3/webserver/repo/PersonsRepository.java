package de.telekom.sea3.webserver.repo;

import de.telekom.sea3.webserver.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository <Person, Long> {
}
