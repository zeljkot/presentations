package streams

import java.util.LinkedList
import java.util.stream.Collectors
import java.util.stream.IntStream
import java.util.stream.Stream

object Parallel {

    fun allNames(persons: Stream<Person>)=
            persons
                .map { (_, firstName, lastName) ->
                    try {
                        Thread.sleep(1)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    "${firstName.toUpperCase()} ${lastName.toUpperCase()}"
                }

}

fun main(args: Array<String>) {
    println("Prepare")
    val people = (0..10000)
            .map { id -> Person(id, "First " + id, "Last " + id, true, LinkedList()) }

    println("GO serial")
    val start = System.currentTimeMillis()
    val result = allNames(people.stream()) //.parallel()
    println("time = " + (System.currentTimeMillis() - start) / 1000.0)

    println("GO parallel")
    val start2 = System.currentTimeMillis()
    val result2 = allNames(people.parallelStream())
    println("time = " + (System.currentTimeMillis() - start2) / 1000.0)

}
