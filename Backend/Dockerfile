FROM openjdk:17.0.1-jdk-slim

WORKDIR /app

COPY target/Backend.jar .

EXPOSE 8080

CMD ["java", "-Duser.timezone=CET", "-jar", "Backend.jar"]