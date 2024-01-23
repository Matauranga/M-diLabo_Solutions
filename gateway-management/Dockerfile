FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/gateway-management-*.jar app.jar

EXPOSE 9002

CMD ["java", "-jar", "app.jar"]
