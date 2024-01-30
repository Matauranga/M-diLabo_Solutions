# Eureka Serveur

Eureka Server is a services and discovery registry server.
This allows microservices to locate and communicate with each other.

It's accessible on port : 9102

## Technologie

* Spring Cloud Starter Netflix Eureka Server 4.1.0

### Docker image

Use the console, go to the corresponding module directory and run the command:

        docker build -t ms-eureka-server .

### Endpoint

Access to eureka registry :
http://localhost:9102/