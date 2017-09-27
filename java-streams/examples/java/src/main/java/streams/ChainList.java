package streams;

import java.util.List;
import java.util.stream.Collectors;

public class ChainList {

    List<Employee> findEmployees(List<Person> persons) {

        return persons.stream()
                .filter(person -> person.isEmployed())
                .map(person -> new Employee(person.getFirstName() + " " + person.getLastName()))
                .collect(Collectors.toList());
    }

    List<String> employeeNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    List<String> nameList(List<Person> persons) {
        return employeeNames(findEmployees(persons));
    }
}
