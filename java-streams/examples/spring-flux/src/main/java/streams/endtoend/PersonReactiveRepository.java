package streams.endtoend;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonReactiveRepository extends ReactiveCrudRepository<Person, String> {

}
