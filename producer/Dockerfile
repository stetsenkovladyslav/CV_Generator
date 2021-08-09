FROM openjdk:15.0.2-jdk-oracle
ARG JAR_FILE=target/producer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","app.jar"]

##
## Build stage
##
#FROM maven:4.0.0-jdk-15-slim AS build
#COPY src /cv_generator/producer/src
#COPY pom.xml /cv_generator/producer/
#RUN mvn -f /cv_generator/producer/pom.xml clean package
##
## Package stage
##
#FROM openjdk:15-jre-slim
#COPY --from=build /cv_generator/producer/target/producer-0.0.1-SNAPSHOT.jar /usr/local/lib/producer.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/usr/local/lib/producer.jar"]