package link.zeljko.docker.server

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Sausage(
        @get:Id
        @get:GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,

        var name: String,
        var paprikaPercentage: Double = 0.0,
        var halal: Boolean = false,
        var kosher: Boolean = false,
        var vege: Boolean = false
)