FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/authentication-service-*.jar app.jar

EXPOSE 9004

CMD ["java", "-jar", "app.jar", "--spring.config.name=application-docker"]
