# Authentication Service

Service that manages authentication, authorizations and everything related to security.

## Technologies

* Spring Boot Starter Data JPA 3.2.1
* Spring Boot Starter Validation 3.2.1
* Spring Boot Starter Web 3.2.1
* Spring Boot Starter Security 3.2.1
* Spring Security Core 6.2.1
* Spring Security Test 6.2.1
* Spring Cloud Starter Netflix Eureka Client 4.1.0-RCI
* H2 Database 2.2.224
* JSON web Token :
    * jjwt-api 0.11.5
    * jjwt-impl 0.11.5
    * jjwt-jackson 0.11.5

### Docker image

Use the console, go to the corresponding module directory and run the command:

        docker build -t ms-authentication .
