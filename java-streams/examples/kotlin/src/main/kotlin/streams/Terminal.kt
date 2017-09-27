package streams

class Terminal {

    internal fun examples(persons: List<Person>) {

        val stream = persons

        val lastNames = stream
                .map { it.lastName }
                .joinToString()

        val lastNamesList = stream
                .map { it.lastName }
                .toList()

        stream.forEach { (_, _, lastName) -> println("person.getLastName() = $lastName") }

        val intStream = 0..20
        val count = intStream.count()
        val sum = intStream.sum()
        val average = intStream.average()
    }
}
