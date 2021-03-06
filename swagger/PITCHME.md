# Aligning REST
# Client and Server
<BR>
### Use Common Interface Definition to Avoid API Drift

<BR>
**Željko Trogrlić**

OG Consultancy Services
<BR>
<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Creative Commons Licence" style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a>

---

# REST Quick Reminder

* Rest is architectural style...
* ... but for many, just JSON over HTTP
* Content of the message is not defined

Note:
REST is today most common standard for communication between server and client.
While REST is actually arcitectural style (web resources, stateless protocol, standard operations),
we usually think about JSON messages over HTTP.
There was no standard how to specify those messages.
How Ivan and I started.

---

# Communicate API with Documentation?

**How to write a documentation?**

_Check the server code and be careful_

**How to write a client?**       

_Check the documentation and be careful_

Note:
Expand API in
* space (number of requests)
* time (API evolution)

---

# What Can We Learn From the Past
Each and every protocol has interface definition language:
* CORBA IDL
* SOAP WSDL

**Generate both client and server from the single source of truth!**

---

![Alt text](http://github.com/OAI/OpenAPI-Style-Guide/raw/master/graphics/bitmap/OpenAPI_Logo_Pantone.png "Logo")
# Swagger / OpenAPI
Swagger is the world’s largest framework of API developer tools 
for the OpenAPI Specification(OAS),
enabling development across the entire API lifecycle,
from design and documentation, to test and deployment.

Note:
* 2010 Wordnik
* 2015 March Smartbeat
* 2015 November Linux Foundation Open API Initiative
  * Google
  * IBM
  * Microsoft

---

# Top-Down Approach:
## Start with the Specification

* Write specification
* Create server (and documentation!)
* Create client

---

# Create Specification

* API description
* paths
* methods
* parameters
* data model

+++?code=swagger/example/minimal.yaml&lang=YAML

@[3-5](Describe API)
@[7-8](Add paths)
@[9-13](Add methods)
@[14-21](Define parameters)
@[22-38](Response)

+++?code=swagger/example/complete.yaml&lang=YAML

@[49-56](Path with ID)
@[63-69](PUT)

@[97-107](Extract data model to definitions section...)
@[25-32](...and reuse it later in response..)
@[36-42](...or as request body.)

---

# Create Server
* 31 supported platforms
* Generated code includes build files

---

# Create Client
* 44 supported platforms
* Use Swagger to generate end-to-end typesafe API (e.g. Typescript + Java)

---

# Bottom-Up:
## Start with the Server Code

* Specification from annotated server code
* Dynamic generation
* For existing projects or API evolution
* Primarily for Java, 3rd party Node.JS

---

# Service Annotations

On different levels:
* class
* method
* parameter

+++?code=swagger/example/server-spring-jaxrs-annotated/src/main/java/presentation/swagger/PersonsApiController.java

@[13-15](Class)
@[12-15](Class)
@[28-30](Method)
@[23-30](Method)
@[32-33](Parameters)
@[31-33](Parameters)

---

# Model Annotations

* class
* property

+++?code=swagger/example/server-spring-jaxrs-annotated/src/main/java/presentation/swagger/Person.java

@[14-16](Class)
@[41-45](Property)

---

# Keep changes under control
Unintended changes:
* Refactoring
* Deep changes
* Swagger induced changes (e.g. "tag")

**TIP: Keep specification in VCS!**

Note:
Spring Boot 2, JAX-RS and Swagger Jackson issue

---

# Takeaway
* Whenever you have API, it will grow through space and time
* Maintenanace will consume resources
  * Source
  * Documentation
* OpenAPI is easy to use standard with rich tooling
* OpenAPI can be easily introduced to existing projects

https://**github**.com/**zeljkot**/presentations/tree/master/swagger

Note:
How it worked out for Ivan and me.
Try Swagger in your existing project!

---
<!-- .slide: class="center" -->

Thank you!
