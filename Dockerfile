FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY target/identidad-service-1.0.0.jar /app/identidad-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "identidad-service.jar"]
