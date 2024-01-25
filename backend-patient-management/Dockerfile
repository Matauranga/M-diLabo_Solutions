FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/backend-patient-management-*.jar app.jar

EXPOSE 9001

CMD ["java", "-jar", "app.jar", "--spring.config.name=application-docker"]