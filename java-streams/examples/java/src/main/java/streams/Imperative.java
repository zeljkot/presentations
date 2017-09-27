package streams;

import java.util.ArrayList;
import java.util.List;

public class Imperative {

    List<Employee> findEmployees(List<Person> persons) {

        List employees = new ArrayList();
        for (Person person : persons) {
            if (person.isEmployed()) {
                Employee employee = new Employee(person.getFirstName() + " " + person.getLastName());
                employees.add(employee);
            }
        }
        return employees;
    }
}
