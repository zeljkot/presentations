package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChainAndIntermediateTerminal {

    Stream<Employee> findEmployees(List<Person> persons) {

        return persons.stream()
                .filter(person -> person.isEmployed())
                .map(person -> new Employee(person.getFirstName() + " " + person.getLastName()));
    }

    Stream<String> employeeNames(Stream<Employee> employees) {
        return employees.map(Employee::getName); // intermediate
    }

    List<String> nameList(List<Person> persons) {
        return employeeNames(findEmployees(persons))
                .collect(Collectors.toList()); // terminal
    }
}
