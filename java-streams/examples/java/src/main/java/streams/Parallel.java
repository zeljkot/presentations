package streams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Parallel {

    static String allNames(Stream<Person> persons) {

        return persons
                .map(person -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return person.getFirstName().toUpperCase() + " " + person.getLastName().toUpperCase();
                })
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println("Prepare");
        List<Person> people = IntStream.range(0, 10000)
                .mapToObj(id -> new Person(id, "First " + id, "Last " + id, true, new LinkedList<>()))
                .collect(Collectors.toList());

        System.out.println("GO serial");
        long start = System.currentTimeMillis();
        String result = allNames(people.stream()); //.parallel()
        System.out.println("time = " + ((System.currentTimeMillis() - start) / 1000.0));

        System.out.println("GO parallel");
        long start2 = System.currentTimeMillis();
        String result2 = allNames(people.stream().parallel());
        System.out.println("time = " + ((System.currentTimeMillis() - start2) / 1000.0));

    }
}
