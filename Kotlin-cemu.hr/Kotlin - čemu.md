<!-- $theme: default -->

Kotlin - čemu?
==============
###### Željko Trogrlić
---
# Uvod
* Statically typed programming language
for the JVM, Android and the browser
* Sažet, siguran, svestran i uskladiv
---
# Povijest
## Jetbrains
## Android
## Gradle
---
* 2003 Groovy
* 2004 *Java 5,* Scala
* 2005
* 2006 *Java 6,* Scala 2.0	
* 2007 Clojure, Gradle
* 2008
* 2009 Oracle...
* 2010 ...kupuje Sun
* 2011 *Java 7,* Kotlin najava, Ceylon
* 2012
* 2013
* 2014 Q1 - *Java 8*
* 2015
* 2016 Q4 - Android lambda , Kotlin 1.0
* 2017 Kotlin 1.1, Java 9, Android Java 8
---
# Osnove - klase, funkcije i varijable
## Klasa
## var i val, getteri i setteri
---
# Konstruktori i data klase
## Primarni konstruktor
## Data klase
* equal
* hashCode
* toString
* copy
---
# null
## Tip ili Tip?
## Sigurni pozivi.?
## Elvis, kralj nulla ?:
## Hoću exception!!
## Java!
---
# Zabava s funkcijama
## Izrazi (expression)
## Default parametri
## Extension funkcije
## Operatori
## Inline
## Infix
---
# `if`, `when` i `try` su fukcije!
## Stilske vježbe u Javi
---
# Klase, objekti i prijatelji
## Klasa vulgaris
## Objekt
## Companion i @JvmStatic
## Java interop
---
# Zbirke
## Jednostavno kreiranje
## Operatori
## Mutable i imutable
---
# Ostalo
## Delegated properties (lazy i sl.)
## Nema "checked" iznimaka (iksepšna)
## Nasljeđivanje
* kostruktori
* open
## Visibility ~~package~~ -> internal
## Import aliasi
## Destructuring
## Interpolacija stringova
## Višelinijski stringovi
---
# Let run with, also apply
## Funkcijska prebacivanja
|vraća|this|it|
|---|---|---|
|isti|apply|also
|drugi|run|let|
```kotlin
val pero = jozo?.let{Pero(jozo.ime, jozo.prezime)}
```
---
# Fast track
---
# Intro 
```kotlin
package link.zeljko.kotlinwhy

data class Celebrity(
        var ime: String? = null,
        var prezime: String? = null,
        var nadimak: String? = null
)

fun main(args: Array<String>) {
    val dwayne = Celebrity("Dwayne", "Johnson", "The Rock")
    val madonna = Celebrity("Madonna")
    val severina = Celebrity(ime = "Severina")

    println("dwayne = ${dwayne}")
    println("madonna = ${madonna}")
    println("severina = ${severina}")
    
    val ivicPasalic = Celebrity(prezime = "Ivić Pašalić")
    val prince = Celebrity(nadimak = "The artist formerly known as Prince")
    
    println(ivicPasalic)
    println("prince = ${prince}")
}
```
---
# Parametri konstruktora
```kotlin
class Test(x: String, y: String ) {

    init {
        println("konstruktor $x, $y")
    }
}
```
---
# Singleton -> Object
```kotlin
object CelebrityList {
    
    fun registrirajCelebrity(celebrity: Celebrity) {}
}

fun main(args: Array<String>) {
    CelebrityList.registrirajCelebrity(dwayne)
}
```
Java
```java
    CelebrityList.INSTANCE.registrirajCelebrity(celebrity);
```
---
# Static -> Companion object
```kotlin
data class Celebrity(...) {

    companion object {
        val averageHeight = 180;
    }
}

fun main(args: Array<String>) {
    println(Celebrity.averageHeight)
}
```
Java
```java
    final int averageHeight = Celebrity.Companion.getAverageHeight();
```
---
# When kao funkcija
```kotlin
    var spol: String =
            when (person2.ime) {
                "Ana" -> "F"
                "Pero", "Jozo" -> "M"
                else -> "MF"
            }
```
---
# Kolekcije
## Mutable i immutable
Lista
```kotlin
    val list = mutableListOf("Jozo", "Marko")
    list += "Đuro"
    list -= "Jozo"
    list[0] = "Stipe"
    println(list[0])
```
Mapa
```kotlin
    val map = mutableMapOf("Marko" to 6)
    map["Pero"] = 1
    map -= "Marko"
    println(map["Pero"])
```
---
# Funkcije: operator, infix

```kotlin
data class Person(
        var ime: String = "",
        var prezime: String? = null
) {
    operator infix fun plus(other: Person) =
        listOf(this, other)
}

fun main(args: Array<String>) {
    person1.plus(person2)
    person1 + person2 // operator
    person1 plus person2 // infix
    
    list += person2
}
```
---
# Funkcije: extensions
```kotlin
data class Person(
        var ime: String = "",
        var prezime: String? = null
)

fun Person.enciklopedijski() = prezime + ", " + ime
```
---
# Funkcije: named i default parametri
```kotlin
    val person1 = Person()
    person1.postaviCijeloIme(ime = "Đuro")
    person1.postaviCijeloIme(ime = "Đuro", prezime = "Đurić")
```
---
# Algebarski tipovi podataka
```kotlin
sealed class CelebrityState {

  class PripremaDjela(studio : Studio, producent : Producent)
      : CelebrityState()
      
  class Turneja(promocije : List<Mjesto>)
      : CelebrityState()
      
  class Pauza(vila : Vila	) 
      : CelebrityState()
}
```
---
# Algebarski tipovi podataka
```kotlin
sealed class CelebrityState {

  class PripremaDjela(studio : Studio, producent : Producent)
      : CelebrityState()
      
  class Kriza(opojnoSredstvo : OpojnoSredstvo, brojPartnera : Long)
      : CelebrityState()
      
  class Odvikavanje(ustanova : Ustanova) 
      : CelebrityState()
}
```
