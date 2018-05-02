FROM openjdk:8-jre-alpine

# Spring Tomcat working directory
VOLUME /tmp

WORKDIR /usr/src/sausage
COPY build/libs/server.jar .
COPY build/resources/main/application-default.yml config/.

EXPOSE 8080

# urandom for faster Tomcat startup
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "server.jar"]