package streams;

import java.util.List;
import java.util.stream.Stream;

public class Filter {

    void examples(List<Person> persons) {

        Stream<Person> stream = persons.stream();

        Stream<Person> justBlackadder = stream
                .filter(person -> person.getLastName().equals("Blackadder"));

        Stream<Person> avoidFirstGeneration = stream
                .skip(5);

        Stream<Person> justFirstGeneration = stream
                .limit(5);

        Stream<Person> firstUnemployed = stream
                .takeWhile(person -> !person.isEmployed());// Java 9

        Stream<Person> skipFirstUnemployed = stream
                .dropWhile(person -> !person.isEmployed());// Java 9

        Stream<Person> skipUnemployedAndTakeWhileEmployed = stream
                .dropWhile(person -> !person.isEmployed()) // Java 9
                .takeWhile(person -> person.isEmployed());// Java 9
    }
}
