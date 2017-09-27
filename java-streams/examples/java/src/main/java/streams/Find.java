package streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Find {

    void examples(List<Person> persons) {

        Stream<Person> stream = persons.stream();

        Optional<Person> firstBlackadder = stream
                .filter(person -> person.getLastName().equals("Blackadder"))
                .findFirst();

        Optional<Person> whicheverBlackadder = stream
                .filter(person -> person.getLastName().equals("Blackadder"))
                .findAny();

        boolean anyMembersOfBlackadderFamily = stream
                .anyMatch(person -> person.getLastName().equals("Blackadder"));

        boolean justBlackadderFamily = stream
                .allMatch(person -> person.getLastName().equals("Blackadder"));
    }
}
