package streams

class Filter {

    fun examples(persons: List<Person>) {

        val justBlackadder =
                persons.filter { it.lastName == "Blackadder" }

        val avoidFirstGeneration =
                persons.drop(5)

        val justFirstGeneration =
                persons.take(5)

        val firstUnemployed =
                persons.takeWhile { person -> !person.isEmployed }

        val skipFirstUnemployed =
                persons.dropWhile { person -> !person.isEmployed }

        val skipUnemployedAndTakeWhileEmployed = persons
                .dropWhile { person -> !person.isEmployed }
                .takeWhile { person -> person.isEmployed }
    }
}
