package streams

class Imperative {

    internal fun findEmployees(persons: List<Person>): List<Employee> {

        val employees = mutableListOf<Employee>()
        for ((_, firstName, lastName, isEmployed) in persons) {
            if (isEmployed) {
                val employee = Employee(firstName + " " + lastName)
                employees += employee
            }
        }
        return employees
    }
}
