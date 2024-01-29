# Gateway Management

This is the entry point to our microservices' architecture. This manages various tasks such as routing, security filters
and communication between front and back services.

## Technologies

* Spring Boot Starter Webflux 3.2.1
* Spring Cloud Starter Gateway 4.1.0-RCI
* Spring Cloud Starter Netflix Eureka Client 4.1.0-RCI
* JSON web Token :
    * jjwt-api 0.11.5
    * jjwt-impl 0.11.5
    * jjwt-jackson 0.11.5

### Docker image

Use the console, go to the corresponding module directory and run the command:

        docker build -t ms-gateway .