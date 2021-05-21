FROM maven:3.6.1-jdk-8-slim AS build
RUN mkdir -p /phonevalidator
WORKDIR /phonevalidator
COPY pom.xml /phonevalidator
COPY src /phonevalidator/src
RUN mvn -f pom.xml clean package

#FROM tomcat:9-jre8-alpine
FROM openjdk:8-alpine
COPY --from=build /phonevalidator/target/*.jar app.jar
COPY sample.db sample.db
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
