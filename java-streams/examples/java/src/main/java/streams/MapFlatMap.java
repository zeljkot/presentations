package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFlatMap {

    List<Employee> findEmployees(List<Person> persons) {

        return persons.stream()
                .map(person -> new Employee(person.getFirstName() + " " + person.getLastName()))
                .collect(Collectors.toList());
    }

    List<Address> findAddresses(List<Person> persons) {

        return persons.stream()
                .flatMap(person -> person.getAddresses().stream())
                .collect(Collectors.toList());
    }

    List<String> nameParts(List<Person> persons) {

        return persons.stream()
                .flatMap(person -> Stream.of(person.getFirstName(), person.getLastName()))
                .collect(Collectors.toList());
    }
}
