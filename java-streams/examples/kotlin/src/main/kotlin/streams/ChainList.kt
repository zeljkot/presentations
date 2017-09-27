package streams

class ChainList {

    internal fun findEmployees(persons: List<Person>) =
            persons
                    .filter(Person::isEmployed)
                    .map { Employee(it.firstName + " " + it.lastName) }

    internal fun employeeNames(employees: List<Employee>) = employees.map { it.name }

    internal fun nameList(persons: List<Person>) = employeeNames(findEmployees(persons))
}
