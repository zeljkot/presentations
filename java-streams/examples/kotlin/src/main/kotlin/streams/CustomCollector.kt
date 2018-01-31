package streams

import java.util.*
import java.util.stream.IntStream
import java.util.stream.Stream

fun allNames(persons: Stream<Person>) =
        persons
                .filter { (_, _, _, isEmployed) -> isEmployed }
                .collect(
                        { StringBuffer() },
                        { stringBuffer, person -> stringBuffer.append(person.firstName).append(", ") },
                        { buffer1, buffer2 -> buffer1.append(buffer2) }
                )

fun main(args: Array<String>) {
    val people = IntStream.range(0, 16)
            .mapToObj { id ->
                Person(
                        id,
                        "First " + id,
                        "Last " + id,
                        true,
                        LinkedList()
                )
            }
    println("names = " + allNames(people))
}

