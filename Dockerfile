FROM openjdk:17-jdk-alpine3.14
COPY ./build/libs/DbService-1.0.0.jar db-service.jar
ENTRYPOINT ["java", "-jar", "db-service.jar"]
