FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY target/identidad-service-0.0.1-SNAPSHOT.jar /app/identidad-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "identidad-service.jar"]
