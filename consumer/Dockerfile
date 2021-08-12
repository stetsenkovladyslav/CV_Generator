#FROM openjdk:15.0.2-jdk-oracle
#ARG JAR_FILE=target/consumer-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","app.jar"]



FROM maven:3.8.1-jdk-11 AS build
WORKDIR .
COPY .. ./
ENTRYPOINT mvn clean pakage && java -jar -Dspring.profiles.active=dev target/consumer-0.0.1-SNAPSHOT.jar