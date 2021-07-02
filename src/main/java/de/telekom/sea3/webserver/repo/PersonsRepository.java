package de.telekom.sea3.webserver.repo;

import de.telekom.sea3.webserver.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonsRepository extends CrudRepository <Person, Long> {

    @Query(value="SELECT * FROM persons WHERE firstname LIKE :text OR lastname LIKE :text",nativeQuery=true )
    Iterable<Person> selectPersons(@Param ("text") String text);
}
