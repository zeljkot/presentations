package streams

class MapFlatMap {

    internal fun findEmployees(persons: List<Person>) =
            persons.map { person -> Employee(person.firstName + " " + person.lastName) }

    internal fun findAddresses(persons: List<Person>) =
            persons.flatMap { person -> person.addresses }

    internal fun nameParts(persons: List<Person>) =
            persons.flatMap { (_, firstName, lastName) -> listOf(firstName, lastName) }
}
