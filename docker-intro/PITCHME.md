# Why Docker?

* Build tools brought easy way to recreate programing language environment
* But there is more:
  * Database
  * Web server
  * Reverse proxy
  * User management (LDAP, Keycloak)

---

Docker reproduces whole development environment

---
# Docker containers vs virtual machines
  * Super-lightweight
  * Shared kernel
  * Shared, layered file system

---
# Lightweigtness

* Kernel with drivers is already "on"
* All containers must have compatible operating system
* No Windows and Linux mixing
  * Windows supports Linux

```docker run -it alpine /bin/sh```
---
# Layered file system

## Example 1
* OS
* Application server
* Application

## Example 2
* OS
* Database
* GIS extensions
* Data files

https://hub.docker.com/r/_/postgres/

Example 1 and 2 can have common OS!

---
# How to start

* Docker image: static
* docker-compose: multi-container environment description 

---

# docker-compose example

Configure and start database

---
# Docker example

PING machine

---
# Docker and Spring Boot
---
# Containers
* Application
  * OS (Alpine Linux)
  * Spring application
* Database
  * OS
  * PostgreSQL

---
# Development vs Production Setup

## Development
Take base image as-is and overlay output file

## Production
Create image with all files
---
# Development setup


---
# Deploy faster

spring-boot-devtools
* Two class loaders
 * libraries
 * dev output

---
# Not fast enough. FASTER!

Note:
https://docs.spring.io/spring-boot/docs/current/reference/html/howto-hotswapping.html

---
# Production setup

---
# Alpine Linux

* Size: 5 MB
* Base
  * musl libc
  * BusyBox
* ash: Almquist shell from BusyBox
* No Bash and other tools, but could be added
---
# Alpine example image

```
FROM alpine:3.5
RUN apk add --no-cache mysql-client
ENTRYPOINT ["mysql"]
```
---
# Alpine bash
```
# apk update
# apk upgrade
# apk add bash
```