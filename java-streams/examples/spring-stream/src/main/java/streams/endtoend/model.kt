package streams.endtoend

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Person(
        @Id @GeneratedValue
        val id: Int,
        val firstName: String,
        val lastName: String
)