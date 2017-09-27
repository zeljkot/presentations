package streams

class Declarative {

    internal fun findEmployees(persons: List<Person>): List<Employee> =
            persons
                    .filter(Person::isEmployed)
                    .map { (_, firstName, lastName) -> Employee(firstName + " " + lastName) }
}
