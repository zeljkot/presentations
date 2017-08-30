Aligning REST Client and Server
==============

###### Use Common Interface Definition to Avoid API Drift
<BR><BR><BR>
###### Željko Trogrlić

---
# REST Quick Reminder
* Resources located by URLs
* Verbs operate on resources
  * GET
  * PUT
  * POST
  * DELETE
* Content of the message is not defined (typically some JSON)
---
# Communicate API with Documentation?

- *How to write a documentation?*      
- Check the server code and be careful |
- *How to write a client?*             |
- Check the documentation and be careful|

Note:
Test note
---
# What Can We Learn From the Past
Each and every protocol has interface definition language:
* CORBA IDL
* SOAP WSDL
---
# What Is It Good For?
Generate both client and server from the single source of truth
---
![Alt text](http://github.com/OAI/OpenAPI-Style-Guide/raw/master/graphics/bitmap/OpenAPI_Logo_Pantone.png "Logo")
# Swagger / OpenAPI
Swagger is the world’s largest framework of API developer tools 
for the OpenAPI Specification(OAS),
enabling development across the entire API lifecycle,
from design and documentation, to test and deployment.
---
# Top-Down Approach:
# Start with a Specification

* Write specification
* Create server (and documentation!)
* Create client
---
# Create Specification
---
# Add Methods

---?code=swagger/example/commonModel.yaml
@[10]
@[32]

---
# Extract Common Definitions

---?code=swagger/example/commonModel.yaml
@[45-64](Extract data model to definitions section...)
@[29-30](...and reuse it later)

---
# Add Paths

---?code=swagger/example/complete.yaml
@[10]
@[50]

---
# Detailed Parameter Specification

---?code=swagger/example/complete.yaml
@[20](Description)
@[21](Required)
@[22](Example)
@[23](Default)

---
# Describe API

---?code=example/complete.yaml
@[3-6]

---
# Create Server
* 31 supported platforms
* Generated code includes build files
---
# Create Client
* 44 supported platforms
* Use Swagger to generate Typescript Typesafe API
---
# Bottom-Up:
# Start with server code

* Specification from annotated server code
* Dynamic generation
* For existing projects or API evolution
* Primarily for Java, 3rd party Node.JS
---
# Service Annotations

---?code=swagger/example/server-spring-jaxrs-annotated/src/main/java/presentation/swagger/PersonsApiController.java
@[13-14](API)
@[23-27](Method)
@[32](Parameters)

---
# Model Annotations

---?code=swagger/example/server-spring-jaxrs-annotated/src/main/java/presentation/swagger/Person.java
@[15]
@[41]

---
# Tricky parts
* Keep specification in VCS!
* Spring Boot 2, JAX-RS and Swagger Jackson issue
* Deep changes
