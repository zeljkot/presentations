Aligning REST Client and Server
==============
###### Use Common Interface Definition to Avoid API Drift
###### Ivan Kaurin & Željko Trogrlić
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
* Check the documentation and be careful
## How to write a documentation?
* Check the server code and be careful
---
# What Can We Learn From the Past
Each and every protocol has interface definition language:
* CORBA IDL
* SOAP WSDL
---
# What is it good for?
Generate both client and server from the single source of truth
---
# Enter Swagger
Swagger is the world’s largest framework of API developer tools 
for the OpenAPI Specification(OAS),
enabling development across the entire API lifecycle,
from design and documentation, to test and deployment.
---
# Use case 1: Start with a Swagger
* Write Swagger definition
* Create documentation
* Create server
---
# Use case 2: Start with server code
* Annotate server code
* Generate Swagger definition
* Create documentation
# Use case 3: End-to-end client and server Typesafe API
* Use Swagger to generate Typescript Typesafe API
