package streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Parallel {

    static String allNames(Stream<Person> persons) {

        return persons
                .filter(person -> person.isEmployed())
                .collect(new Collector<Person, StringBuffer, String>() {
                    @Override
                    public Supplier<StringBuffer> supplier() {
                        return () -> new StringBuffer();
                    }

                    @Override
                    public BiConsumer<StringBuffer, Person> accumulator() {
                        return (stringBuffer, person) -> stringBuffer.append(person.getFirstName()).append(", ");
                    }

                    @Override
                    public BinaryOperator<StringBuffer> combiner() {
                        return (buffer1, buffer2) -> {
                            //System.out.println("combine = " + buffer1 + " and " + buffer2);
                            return buffer1.append(buffer2);
                        };
                    }

                    @Override
                    public Function<StringBuffer, String> finisher() {
                        return (stringBuffer -> {
                            stringBuffer.setLength(stringBuffer.length() - 2);
                            return stringBuffer.toString();
                        });
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        //return Set.of(Characteristics.CONCURRENT);
                        return new HashSet<>(Arrays.asList(Characteristics.CONCURRENT));
                    }
                });
    }

    public static void main(String[] args) {
        Stream<Person> people = IntStream.range(0, 10000000)
                .mapToObj(id -> new Person(id, "First " + id, "Last " + id, true, new LinkedList<>()));
        long start = System.currentTimeMillis();
        String result = allNames(people);
        System.out.println("time = " + ((System.currentTimeMillis() - start) / 1000.0));
    }
}
