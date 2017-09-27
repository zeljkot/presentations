# Java Streams
<BR>
### Not how, what

<BR>
**Željko Trogrlić**

<BR>
<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Creative Commons Licence" style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a>

---
# Imperative vs  Declarative

* Imperative: HOW
* Declarative: WHAT

---

# Imperative example

+++?code=java-streams/examples/java/src/main/java/streams/Imperative.java&lang=Java

@[10-17](Imperative style)

---

# Declarative style

Note:

Wikipedia:
* A high-level program that describes what a computation should perform.
* Any programming language that lacks side effects (or more specifically, is referentially transparent)
* A language with a clear correspondence to mathematical logic.

Functional and logical programming languages

+++?code=java-streams/examples/java/src/main/java/streams/Declarative.java&lang=Java

@[10-13](Declarative style)

---

# Filtering

* filter(>=5) (1 3 **7** **8** 2 4 0 **9** **5**)
* skip(4) (1 3 7 8 **2 4 0 9 5**)
* limit(4) (**1 3 7 8** 2 4 0 9 5)
* takeWhile(<5) (**1 3** 7 8 2 4 0 9 5)
* dropWhile(<5) (1 3 **7 8 2 4 0 9 5**)
* dropWhile(<5)/takewhile(>5) (1 3 **7 8** 2 4 0 9 5)

Note:

GPS coordinates in station
 1 3 **7** **8** 2 4 0 **9** **5**

+++?code=java-streams/examples/java/src/main/java/streams/Filter.java&lang=Java

@[12-13](filter{>=5} {1 3 **7** **8** 2 4 0 **9** **5**})
@[15-16](skip{5} {1 3 7 8 2 **4 0 9 5**})
@[18-19](limit{4} {**1 3 7 8 2** 4 0 9 5})
@[21-22](takeWhile{<5} {**1 3** 7 8 2 4 0 9 5})
@[24-25](dropWhile{<5} {1 3 **7 8 2 4 0 9 5**})
@[27-29](dropWhile{<5}/takewhile{>5} {1 3 **7 8** 2 4 0 9 5})

---

# Finding

* findFirst
* findAny
* anyMatch
* allMatch

+++?code=java-streams/examples/java/src/main/java/streams/Find.java&lang=Java

@[13-15](findFirst)
@[17-19](findAny)
@[21-22](anyMatch)
@[24-25](allMatch)

---

# Converting (mapping)

* map - 1 : 1
* flatMap - 1 : _n_

+++?code=java-streams/examples/java/src/main/java/streams/MapFlatMap.java&lang=Java

@[11-13](map)
@[18-20](flatMap)
@[25-27](flatMap)

---

# Terminal

* Either side-effect or value
  * collect
  * forEach
  * count, sum, average...

+++?code=java-streams/examples/java/src/main/java/streams/Terminal.java&lang=Java

@[15-17](collect)
@[19-21](collect)
@[23](forEach)
@[26-28](Numeric)

---

# Folding / Reducing

* reduce()
* Also terminal
* Sums up stream to single value

+++?code=java-streams/examples/java/src/main/java/streams/FoldReduce.java&lang=Java

@[13-14](reduce int)
@[32-38](reduce area)
@[46-51](fold area to chairs)

---

# Parallel processing

* parallel()
* simple way to activate multithreading

+++

# Example

```kotlin
splitFiles(fileList, (60L * 1024 * 1024 * 1).toLong(), tempDir)
    .mapIndexed { index, mutableList -> index to mutableList }
    .parallelStream()
    .map { (index, documents) -> index to binder.copy(children = Converter.makeTree(documents)) }
    .forEach { (index, subBinder) ->
        val subOutputFile = File(outputFile.parent, "${outputFile.nameWithoutExtension}-%03d.pdf".format(index))
        coverAndMerge(subBinder, tempDir, subOutputFile, settings)
        addBookmarks(subBinder, tempDir, subOutputFile, 1)
    }
```

+++?code=java-streams/examples/java/src/main/java/streams/Parallel.java&lang=Java
@[33] Without parallel
@[38] With parallel
---

# Additional topics

* Streams everywhere
* Custom collector

+++?code=java-streams/examples/java/src/main/java/streams/ChainList.java&lang=Java

Lists everywhere - lots of object allocation

+++?code=java-streams/examples/java/src/main/java/streams/ChainAndIntermediateTerminal.java&lang=Java

Streams everywhere - less allocation

+++?code=java-streams/examples/java/src/main/java/streams/CustomCollector.java&lang=Java

Custom collector

---
# End-to-end

## From database to web client
* get database stream from Hibernate
* process as stream
* convert to JSON as stream
* write to response as stream

---

# Takeaway

* Code with streams is easier to write
* Code with streams is easier to understand
* Streams provide cheap parallelism

* Some tools provide automatic conversion - so go and convert!

https://**github**.com/**zeljkot**/presentations/tree/master/java-stream

---
<!-- .slide: class="center" -->

Thank you!
