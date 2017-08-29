package presentation.swagger;


import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    //Person findByFirstName(String firstName);

    //List<Person> findByLastName(String lastName);
}
