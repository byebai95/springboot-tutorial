FROM openjdk:8-jdk-alpine

MAINTAINER Howl <Howl@email.com>

COPY target/p11-docker-1.0-SNAPSHOT.jar app.jar

EXPOSE 9000

ENTRYPOINT ["java","-jar","/app.jar"]
