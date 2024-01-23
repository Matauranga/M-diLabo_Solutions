FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/backend-note-*.jar app.jar

EXPOSE 9005

CMD ["java", "-jar", "app.jar"]