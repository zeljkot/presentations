package streams;

import java.util.LinkedList;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CustomCollector {

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
                        return (buffer1, buffer2) -> buffer1.append(buffer2);
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
                        return Set.of(Characteristics.CONCURRENT);
                    }
                });
    }

    public static void main(String[] args) {
        Stream<Person> people = IntStream.range(0, 16)
                .mapToObj(operand -> new Person("First " + operand, "Last " + operand, true, new LinkedList<>()));
        System.out.println("names = " + allNames(people));
    }
}
