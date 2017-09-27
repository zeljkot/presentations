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

        List<String> lastNamesList = stream
                .map(Person::getLastName)
                .collect(Collectors.toList());

        stream.forEach(person -> System.out.println("person.getLastName() = " + person.getLastName()));

        IntStream intStream = IntStream.range(0, 20);
        long count = intStream.count();
        int sum = intStream.sum();
        OptionalDouble average = intStream.average();
    }
}
