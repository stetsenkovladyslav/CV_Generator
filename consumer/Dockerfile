#FROM openjdk:15.0.2-jdk-oracle
#ARG JAR_FILE=target/consumer-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","app.jar"]
#

#FROM maven:3.5-jdk-15-slim AS build
#COPY src /cv_generator/consumer/src
#COPY pom.xml /cv_generator/consumer/
#RUN mvn -f /cv_generator/consumer/pom.xml clean package
#COPY --from=build /cv_generator/consumer/target/consumer-0.0.1-SNAPSHOT.jar consumer.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","consumer.jar"]




#FROM maven:3.8.1-jdk-11 AS build
#COPY pom.xml /cv_generator/producer/
#COPY src /cv_generator/consumer/src
#RUN mvn -f /cv_generator/consumer/pom.xml clean package

#FROM openjdk:15.0.2-jdk-oracle
#COPY --from=build /cv_generator/consumer/target/consumer-0.0.1-SNAPSHOT.jar consumer.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","consumer.jar"]


FROM maven:3.8.1-jdk-11 AS build
WORKDIR .
COPY ./ ./consumer
COPY ../pom.xml ./
ENTRYPOINT mvn clean pakage && java -jar -Dspring.profiles.active=dev target/consumer-0.0.1-SNAPSHOT.jar