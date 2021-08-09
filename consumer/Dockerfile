FROM openjdk:15.0.2-jdk-oracle
ARG JAR_FILE=target/consumer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","app.jar"]

#
##
## Build stage
##
#FROM maven:4.0.0-jdk-15-slim AS build
#COPY src /cv_generator/consumer/src
#COPY pom.xml /cv_generator/consumer/
#RUN mvn -f /cv_generator/consumer/pom.xml clean package
##
## Package stage
##
#FROM openjdk:15-jre-slim
#COPY --from=build /cv_generator/consumer/target/consumer-0.0.1-SNAPSHOT.jar /usr/local/lib/consumer.jar
#EXPOSE 8081
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/usr/local/lib/consumer.jar"]