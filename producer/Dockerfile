#FROM openjdk:15.0.2-jdk-oracle
#ARG JAR_FILE=target/producer-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","app.jar"]

#FROM maven:3.8.1-jdk-11 AS build
#COPY pom.xml /cv_generator/producer/
#COPY src /cv_generator/producer/src
#RUN mvn -f pom.xml clean package
#FROM openjdk:15.0.2-jdk-oracle
#COPY --from=build target/producer-0.0.1-SNAPSHOT.jar producer.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","producer.jar"]

#FROM maven:3.8.1-jdk-11 AS build
#WORKDIR .
#COPY . ./
##ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","producer.jar"]
#ENTRYPOINT mvn clean install  java -jar -Dspring.profiles.active=dev build/libs/app-0.0.1-SNAPSHOT.jar

FROM maven:3.8.1-jdk-11 AS build
WORKDIR .
COPY ./ ./producer
COPY ../pom.xml ./
ENTRYPOINT  mvn clean pakage && java -jar -Dspring.profiles.active=dev target/producer-0.0.1-SNAPSHOT.jar