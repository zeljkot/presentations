package streams.endtoend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.stream.Stream;

public interface PersonRepository extends CrudRepository<Person, String> {

    @Query("select p from Person p")
    Stream<Person> streamAll();

}
