package streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoolStuff {

    void examples(List<Person> persons) {

        Stream<Person> stream = persons.stream();

        stream
                .map(person -> person.getLastName())
                .collect(Collectors.joining());

        stream
                .map(Person::getLastName)
                .collect(Collectors.joining());

        stream
                .map(Person::getLastName)
                .collect(Collectors.joining(",", "[", "]"));

        Optional<Person> blackadder1 = stream
                .filter(person -> person.getLastName().equals("Blackadder"))
                .findAny();

        boolean blackadderFamily = stream
                .allMatch(person -> person.getLastName().equals("Blackadder"));

        stream
                .skip(3)
                .map(person -> person.getLastName())
                .collect(Collectors.joining());

        stream
                .takeWhile(person -> !person.isEmployed()); // Java 9

        stream
                .dropWhile(person -> !person.isEmployed()); // Java 9

        stream
                .dropWhile(person -> !person.isEmployed()) // Java 9
                .takeWhile(person -> person.getLastName().equals("Blackadder")); // Java 9
    }
}
