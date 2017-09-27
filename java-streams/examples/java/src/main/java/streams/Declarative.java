package streams;

import java.util.List;
import java.util.stream.Collectors;

public class Declarative {

    List<Employee> findEmployees(List<Person> persons) {

        return persons.stream()
                .filter(person -> person.isEmployed())
                .map(person -> new Employee(person.getFirstName() + " " + person.getLastName()))
                .collect(Collectors.toList());
    }
}
