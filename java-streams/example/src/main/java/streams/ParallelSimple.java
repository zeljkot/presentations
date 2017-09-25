package streams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelSimple {

    static String allNames(Stream<Person> persons) {

        return persons
                .map(person -> person.getFirstName().toUpperCase() + " " + person.getLastName().toUpperCase())
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println("Prepare");
        List<Person> people = IntStream.range(0, 10000000)
                .mapToObj(operand -> new Person("First " + operand, "Last " + operand, true, new LinkedList<>()))
                .collect(Collectors.toList());
        System.out.println("GO");
        long start = System.currentTimeMillis();
        String result = allNames(people.stream()); //.parallel()
        System.out.println("time = " + ((System.currentTimeMillis() - start) / 1000.0));
    }
}
