package streams

class Find {

    internal fun examples(persons: List<Person>) {

        val firstBlackadder =
                persons.first { it.lastName == "Blackadder" }

        val whicheverBlackadder =
                persons.find { it.lastName == "Blackadder" }

        val anyMembersOfBlackadderFamily =
                persons.any { it.lastName == "Blackadder" }

        val justBlackadderFamily =
                persons.all { it.lastName == "Blackadder" }
    }
}
