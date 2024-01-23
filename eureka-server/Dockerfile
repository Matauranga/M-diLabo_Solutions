FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/eureka-server-*.jar app.jar

EXPOSE 9102

CMD ["java", "-jar", "app.jar"]
