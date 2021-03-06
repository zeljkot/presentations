﻿﻿
![Javantura 2018](kotlin-backend/javantura.png)


# Server-side Kotlin

### Željko Trogrlić

---
# Why Would I use It For Backend

* Statically typed programming language for modern multiplatform applications 
* Multiparadigm (object/functional)
* Expressiveness
* Safety
* Java interoperability
* Framework integration (Spring, Jackson)

Note:
Support in popular frameworks

---
# Case 1: Attack of the Getters and Setters

Q: How many times you have to write "person" to create a person property?

+++
# Kotlin Entities

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

+++
# Kotlin Features

* Properties
* Data classes
 * equals(), hashCode(), toString()

Note:
Be careful with equals!

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
No variables, minimal scope.
Spring does not need parameter names
Property @Inject is unnatural for Kotlin

+++
# Advantages

* constructor injection, no need for @PostConstruct methods
* null safety
* operator overloading
* available parameter names (usability depends on framework)

---
# Case 3: Parameter Names

Jackson immutable class 

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

---
# HTTP parameters

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

---
# Converting Entity Bean

```java
@Entity
public class KittenEntity
    implements Kitten {

  @Id
  @GeneratedValue
  private Integer id;
  private String  name;
  private int     cuteness;

  protected KittenEntity() {
  }

  public KittenEntity(String name, int cuteness) {
    this.name = name;
    this.cuteness = cuteness;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCuteness() {
    return this.cuteness;
  }

  public void setCuteness(int cuteness) {
    this.cuteness = cuteness;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    KittenEntity that = (KittenEntity) o;

    if (cuteness != that.cuteness) {
      return false;
    }
    if (!id.equals(that.id)) {
      return false;
    }
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "KittenEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", cuteness=" + cuteness +
        '}';
  }
}
```

---
# Conversion Steps
* Use automatic conversion
* Remove all getters and setters
* Remove toString()
* Be careful with hashCode() and equals()

Note:
Remove getters and setters and standard Class methods.
Show decompiled code.

---
# Result

* Parameterless constructor needed

```kotlin
@Entity
data class KittenEntity(
        @Id
        @GeneratedValue
        var id: Int?,
        override var name: String,
) : Kitten {
    private constructor() : this(null, "")
}
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
# Issues with Java EE Beans and Spring Components

* Managed classes must be extended
 * Create non-final classes, so framework can add wrappers with special sauce, like transactions
* Kotlin classes
 * **Everything is final and public**

Note:
Inspired by Effective Java

---
# Opening Classes Up

Frameworks cannot work with final classes.

```kotlin
@Stateless
open class KittenBusinessService {

    open fun add(kitten: KittenEntity) = ...

    open fun find(id: Int): Optional<KittenEntity> = ...
}
```

---
# Compiler Plugin Workaround

```groovy
plugins {
  ...
  id("org.jetbrains.kotlin.plugin.allopen") version("x.x.x")
}

apply {
  ...
  plugin("kotlin-allopen")
  plugin("kotlin-spring")
}

allOpen {
  annotation("javax.ws.rs.Path")
  annotation("javax.ejb.Stateless")
}
```

---
# @Inject / @Autowire Troubles

```kotlin
@Inject
protected val service: Service
// ...
service.persist(kitten)
```
* Class initialization order
 * Construct
 * Inject values
 * @PostConstruct

--- 
# @Inject / @Autowire Troubles

```kotlin
@Inject
protected var service: Service? = null
// ...
service!!.persist(kitten)
```

* Injected values must
 * accept null
 * be mutable
 * all calls must be null-safe

---
# `lateinit` to the Rescue

```kotlin
@Inject
protected lateinit var service: Service
// ...
service.persist(kitten)
```

This is the way to go with EntityManager!

---
# @Inject through Constructor

```kotlin
class KittenController @Inject constructor(
    private val service: Service) {

  // ...
  service.persist(kitten)
```

* all necessary values are available at construction time
* constructor can use them
* properties can be immutable and non-nullable

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

* Three and a half projects running smoothly
* More efficient and enjoyable than Java
* Converted frontend developers

---
# Java vs Kotlin Today
* Java is closing the gap
 * 8: -parameters adds name metadata
 * 9: additional stream functions
 * 10: JEP 286 - inferred vars
* Kotlin guides you to better style, and has
 * extension and inline functions
 * operator overloading
 * statemens as functions (if, try, when)
---
# What Can You Do Now?

* Convert a unit test. Convert some more.
* Play with language features.
* Convert a production class.
* Have fun!
---
# Need more?

Check three part series at
http://zeljko.link

---
# Case 1: Attack of the Getters and Setters

Q: how many times you have to write "person" to create person property?

```java
private Person person;

public Person getPerson() {
  return person;
}

void setPerson(Person person) {
  this.person = person;
}
```

---
# Thank you!
