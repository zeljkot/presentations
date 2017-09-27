package streams.endtoend

import org.springframework.data.mongodb.core.mapping.Document

@Document // TODO
data class Person(
        //TODO @Id @GeneratedValue
        val id: Int,
        val firstName: String,
        val lastName: String
)