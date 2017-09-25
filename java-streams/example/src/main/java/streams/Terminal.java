package streams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Terminal {

    void examples(List<Person> persons) {

        Stream<Person> stream = persons.stream();

        String lastNames = stream
                .map(person -> person.getLastName())
                .collect(Collectors.joining());

        String nicerLastNames = stream
                .map(Person::getLastName)
                .collect(Collectors.joining(",", "[", "]"));

        stream.forEach(person -> System.out.println("person.getLastName() = " + person.getLastName()));

        long count = IntStream.range(0, 20).count();
        int sum = IntStream.range(0, 20).sum();
        OptionalDouble average = IntStream.range(0, 20).average();
    }
}
