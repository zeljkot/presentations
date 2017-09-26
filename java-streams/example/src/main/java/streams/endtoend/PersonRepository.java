package streams.endtoend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface PersonRepository extends CrudRepository<Person, String> {

    @Query("select p from Person p")
    Stream<Person> streamAll();
}
