﻿![Logo](javantura.png)

# Kotlin JEE

## Željko Trogrlić

---
# What is Kotlin?

* Statically typed programming language for modern multiplatform applications 
* Characteristics:
  * Concise
  * Safe
  * Interoperable
* Multiparadigm (object/functional)

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

+++
# Expresiveness

```kotlin
val counter = 6

val message = try {
  getMessage()
} catch (ex : Exception) {
  ex.message
}
```
---
# Case 1: Attack of the Getters and Setters

* Properties
* Data classes
 * equals(), hashCode(), toString()

Note:
Be careful with equals!
---
# Example

Q: how many times you have to write "person" to create person property?

+++

```java
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

```kotlin
@Entity
data class KittenEntity(
        @Id @GeneratedValue
        var id: Int?,
        override var name: String,
        override var cuteness: Int // set Int.MAX_VALUE for Nermal
) : Kitten
```

Note:
No body

---
# Case 2: Immutable, Functional Service Class

```kotlin
@Path("kitten")
class KittenController @Inject constructor(
    private val kittenService: KittenService) {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  fun add(kittenRest: KittenRest): Int = 
      kittenRest
          .let { KittenEntity(it.name, it.cuteness) }
          .also { kittenBusinessService += it }
          .let { it.id!! }

```

Note:
Spring does not need parameter names
Property @Inject is unnatural for Kotlin

+++
# Advantages

* constructor injection, no need for @PostConstruct methods
* null safety
* operator overloading
* available parameter names (usability depends on framework)

---
# Case 3: Parameter names

http://kitten.service/search?name=Garfield&weight=100

```kotlin
@GET
fun add(
    @QueryParam("name") name: String?,
    @QueryParam("weight") weight: Double?
): List<Kitten>
```

Note:
-parameters stores formal parameter names of constructors and methods in the generated class file
Required/nullable

+++
# Jackson immutable classes 

Constructor mapping needs metadata.

---
# Adding Kotlin to Build File
```groovy
plugins {
    id "org.jetbrains.kotlin.jvm" version '1.2'
}

apply plugin: 'kotlin'
apply plugin: 'war'

description = 'My Server'

dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
}
```
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
```kotlin
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

```kotlin
@Stateless
open class KittenBusinessService {

    open fun add(kitten: KittenEntity) = ...

    open fun find(id: Int): Optional<KittenEntity> = ...
}
```

---
# Evolution of Property @Inject

```kotlin
protected val service: Service
// ...
service.persist(kitten)
```

+++

Must be nullable and mutable, so

```kotlin
protected var service: Service? = null
// ...
service.persist(kitten)
```

+++

Must check for nulls, so

```kotlin
protected var service: Service? = null
// ...
service!!.persist(kitten)
```

---
# `lateinit` to the Rescue

```kotlin
protected lateinit var service: Service
// ...
service.persist(kitten)
```

---
# @Inject through Constructor

```kotlin
class KittenController @Inject constructor(
    private val service: Service) {
```

---
# What Anout EntityManager?

No @Inject, no constructor injection

```kotlin
@PersistenceContext
private lateinit var entityManager: EntityManager
// ...
entityManager.persist(kitten)
```

---
# Taming the Kotlin with compiler plugins

* Plugins change the way how bytecode is generated
 * Classes can become magically open
 * Parameterless constructors will magically appear

---
# Parameterless constructors workaround

```groovy
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

```groovy
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

```kotlin
data class KittenRest(
  @param:JsonProperty("name")
  override val name: String,
  @param:JsonProperty("cuteness")
  override val cuteness: Int
) : Kitten
```
with the help of jackson-module-kotlin becomes

```kotlin
data class KittenRest(
  override val name: String,
  override val cuteness: Int
) : Kitten
```

Note:
Not a compiler plugin.

---
# Support in Spring

* null safety
 * Spring is annotated
 * Spring detects Kotlin's "Type?"
* Bean DSL
* WebFlux DSL 

Note:
JSR-305 + Spring
-Xjsr305=warn
---
# Spring Bean DSL

```kotlin
fun beans() = beans {
    bean<UserHandler>()
    bean<Routes>()
    bean<WebHandler>("webHandler") {
        RouterFunctions.toWebHandler(
            ref<Routes>().router(),
            HandlerStrategies.builder().viewResolver(ref()).build()
        )
    }
    ...
}
```

---
# WebFlux DSL

```
router {
    accept(TEXT_HTML).nest {
        GET("/") { ok().render("index") }
        GET("/sse") { ok().render("sse") }
        GET("/users", userHandler::findAllView)
    }
    "/api".nest {
        accept(APPLICATION_JSON).nest {
            GET("/users", userHandler::findAll)
        }
    ...
```

---
# Kotlin backend one year later

* Three and a half projects
* Occasional problems with plugins
* Converted frontend developers

---
# What Can You Do Now?

* Convert a unit test. Convert some more.
* Play with language features.
* Convert a production class.
* Have fun!
---
# Need more?

Check three part series on
http://zeljko.link

---
# Thank you!
