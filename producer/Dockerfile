FROM maven:3.8.1-jdk-11 AS build
WORKDIR .
COPY .. ./
ENTRYPOINT mvn clean install && java -jar -Dspring.profiles.active=dev producer/target/producer-0.0.1-SNAPSHOT.jar