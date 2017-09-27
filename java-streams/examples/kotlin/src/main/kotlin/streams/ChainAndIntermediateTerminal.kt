package streams

class ChainAndIntermediateTerminal {

    fun findEmployees(persons: Sequence<Person>) =
            persons.asSequence()
                    .filter(Person::isEmployed) // intermediate
                    .map { person -> Employee("${person.firstName} ${person.lastName}") } // intermediate

    fun employeeNames(employees: Sequence<Employee>) =
            employees.map { it.name } // intermediate

    fun nameList(persons: List<Person>) =
            employeeNames(findEmployees(persons.asSequence())).toList() // terminal

    fun nameList2(persons: List<Person>) =
            persons.asSequence()
                    .let { findEmployees(it) }
                    .let { employeeNames(it) }
                    .toList() // terminal

}
