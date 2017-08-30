Aligning REST Client and Server
==============

###### Use Common Interface Definition to Avoid API Drift

###### Željko Trogrlić
---
# What is REST about
## Quick reminder
* Resources located by URLs
* Verbs operate on resources
  * GET
  * PUT
  * POST
  * DELETE
* Content of the message is not defined (typically some JSON)
---
## How to write a client?

Check the documentation and be careful
 
## How to write a documentation?

Check the server code and be careful
---
# What Can We Learn From the Past
Each and every protocol has interface definition language:
* CORBA IDL
* SOAP WSDL
---
# What is it good for?
Generate both client and server from the single source of truth
---
[[https://github.com/OAI/OpenAPI-Style-Guide/blob/master/graphics/vector/OpenAPI_Logo_Pantone.svg|alt=OpenAPILogo]]
# Enter Swagger / OpenAPI Specification
Swagger is the world’s largest framework of API developer tools 
for the OpenAPI Specification(OAS),
enabling development across the entire API lifecycle,
from design and documentation, to test and deployment.
---
# Top-Down Approach: Start with a specification
* Write specification
* Create server (and documentation!)
* Create client
---
# Create Specification
---
# Common definitions
Extract data model to definitions section...
```
definitions:
  person:
    description: User of the app
    type: object
    required:
      - name
    properties:
      name:
        description: First and last name
        type: string
```
---
# Common definitions
...and reuse it later
```
parameters:
  - name: person
    in: body
    schema:
      $ref: '#/definitions/person'
```
---
# Add more stuff
* Paths
  * Methods
---
# Create server
* 31 supported platforms
* Generated code includes build files
---
# Create client
* 44 supported platforms
* Use Swagger to generate Typescript Typesafe API
---
# Bottom-Up: Start with server code
* Specification from annotated server code
* Dynamic generation
* For existing projects or API evolution
* Primarily for Java, 3rd party Node.JS
---
# Tricky parts
* Keep specification in VCS!
* Spring Boot 2, JAX-RS and Swagger Jackson issue
* Deep changes
