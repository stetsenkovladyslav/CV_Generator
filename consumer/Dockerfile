FROM maven:3.8.1-jdk-11 AS build
WORKDIR ./usr/app
COPY .. ./
ENTRYPOINT mvn clean install && java -jar -Dspring.profiles.active=dev consumer/target/consumer-0.0.1-SNAPSHOT.jar