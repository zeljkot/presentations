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
# Top-Down Approach: Start with a Swagger
* Write Swagger definition
* Create server (and documentation!)
* Create client
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
# Bottom-Up: Start with server code
* Annotate server code
* Generate Swagger definition
* Create documentation
* Keep specification in VCS!
# Use case 3: End-to-end client and server Typesafe API
* Use Swagger to generate Typescript Typesafe API
