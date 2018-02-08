﻿﻿﻿
﻿﻿﻿# Kotlin JEE

## Željko Trogrlić

---
# What is Kotlin?

---
# Isn't it Just for the Android?

* Until recently, Android supported Java 6 w/ extensions
* No streams, no closures
* Kotlin provides everything, and more

---
# Why Would I use It For Backend

* Expressiveness
* Safety
* Java interoperability
* Framework integration

Note:
Support in popular frameworks

---
# Case 1: Attack of the Getters and Setters

* Properties
* Data classes
 * equals(), hashCode(), toString()

---
# Example

Q: how many times you have to write "person" to create person property?

+++

```
private Person person;

public Person getPerson() {
  return person;
}

void setPerson(Person person) {
  this.person = person;
}
```

+++
# Kotlin Version

```
@Entity
data class KittenEntity private constructor(
        @Id
        @GeneratedValue
        var id: Int?,
        override var name: String,
        override var cuteness: Int // set Int.MAX_VALUE for Nermal
) : Kitten
```

Note:
No body

---
# Case 2: Functional Service Class

```
@Path("kitten")
class KittenRestService @Inject constructor(private val kittenBusinessService: KittenBusinessService) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun add(
            kittenRest: KittenRest
    ): Int = kittenRest
            .let { KittenEntity(it.name, it.cuteness) }
            .also { kittenBusinessService += it }
            .let { it.id!! }

```

Note:
Spring does not need parameter names

---
# Advantages

* constructor injection, no need for postXxx methods
* null safety
* operator overloading
* available parameter names (usability depends on framework)

+++
# Parameter names

http://kitten.service/search?name=Garfield&weight=100

```
@GET
fun add(
    @QueryParam("name") name: String?,
    @QueryParam("weight") weight: Double?
): List<Kitten>
```

---
# Case 3: Jackson immutable classes 

Constructor mapping needs metadata

---
# Converting Entity Bean

Note:
Remove getters and setters and standard Class methods.
Show decompiled code.

---
# Kotlin class specifics
* **Everything is final and public**
* Frameworks need:
 * non-final classes
  * wrappers with special sauce, like transactions
 * parameterless constructors

Note:
Inspired by Effective Java

---
# Parameterless constructor
```
@Entity
data class KittenEntity private constructor(
        @Id
        @GeneratedValue
        var id: Int?,
        override var name: String,
) : Kitten {
    private constructor() : this(null, "")
}
```
---
# Opening classes up

Frameworks cannot work with final classes.

```
@Stateless
open class KittenBusinessService {

    open fun add(kitten: KittenEntity) = ...

    open fun find(id: Int): Optional<KittenEntity> = ...
}
```

---
# What about EntityManager

* It is injected in a different way (`@PersistenceContext`)
* It must be nullable

```
@PersistenceContext
private var entityManager: EntityManager?
```
* Unless we declare it `lateinit` 

```
@PersistenceContext
private lateinit var entityManager: EntityManager
```
---
# Taming the Kotlin with compiler plugins

* Plugins change the way how bytecode is generated
 * Classes can become magically open
 * Parameterless constructors will magically appear

---
# Parameterless constructors workaround

```
plugins {
  id("org.jetbrains.kotlin.plugin.noarg") version("x.x.x")
  id( "org.jetbrains.kotlin.plugin.jpa" ) version ( "x.x.x")
}

apply {
  ...
  plugin("kotlin-noarg")
  plugin("kotlin-jpa")
}

noArg {
  annotation("javax.ws.rs.Path")
  annotation("javax.ejb.Stateless")
}
```

---
# Class opening workaround

```
plugins {
  ...
  id("org.jetbrains.kotlin.plugin.allopen") version("x.x.x")
}

apply {
  ...
  plugin("kotlin-allopen")
}

allOpen {
  annotation("javax.ws.rs.Path")
  annotation("javax.ejb.Stateless")
}
```

---
# Jackson Construction

```
data class KittenRest(
  @param:JsonProperty("name")
  override val name: String,
  @param:JsonProperty("cuteness")
  override val cuteness: Int
) : Kitten
```
with the help of jackson-module-kotlin becomes

```
data class KittenRest(
  override val name: String,
  override val cuteness: Int
) : Kitten
```

Note:
Not a compiler plugin.

---
# Kotlin backend one year later

* Going strong
* Occasional problems with plugins
* Converted frontend developers
* Would I recommend it to a friend?
