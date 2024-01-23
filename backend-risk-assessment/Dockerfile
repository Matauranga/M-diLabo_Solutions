FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/backend-risk-assessment-*.jar app.jar

EXPOSE 9006

CMD ["java", "-jar", "app.jar"]