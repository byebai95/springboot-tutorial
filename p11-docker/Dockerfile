FROM openjdk:8-jdk-alpine

MAINTAINER [author] [Howl@email.com]

ARG JAR_FILE=/target/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 9000

ENTRYPOINT ["java","-jar","/app.jar"]
