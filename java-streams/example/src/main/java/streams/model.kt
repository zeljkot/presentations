package streams

data class Person(
        val firstName: String,
        val lastName: String,
        val isEmployed: Boolean = false,
        val addresses: List<Address> = listOf()
)

data class Address(val street: String)

data class Employee(
        val name: String
)