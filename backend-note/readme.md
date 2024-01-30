# Backend Note

CRUD API for managing doctors' notes on patients.
Storing data in a MongoDB database.

It presents his result on the port : 9005

## Technologies

* Spring Boot Starter Data MongoDB 3.2.1
* Spring Boot Starter Web 3.2.1
* Spring Cloud Starter Netflix Eureka Client 4.1.0
* Spring test 6.1.2
* DataFaker 1.6.0

### Docker image

Use the console, go to the corresponding module directory and run the command:

        docker build -t ms-backend-note .

## Database connection

* Port = 27017
* Database name = noteTest

## Endpoints

### Get

Get all patient note's :
http://localhost:9005/notes/{patientId}

* ex :
    * http://localhost:9005/notes/2
        * result

                    {
                      "id": "659d74c8a777824a31169ef0",
                      "patientId": "2",
                      "content": "Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois\r\nIl remarque
                      également que son audition continue d'être anormale",
                      "date": "2024-01-09T16:31:04.841+00:00"
                    },
                    {
                      "id": "659d74aca777824a31169eef",
                      "patientId": "2",
                      "content": "Le patient déclare qu'il ressent beaucoup de stress au travail\r\nIl se plaint également que son
                      audition est anormale dernièrement",
                      "date": "2024-01-09T16:30:36.897+00:00"
                    }

### Post

Add note to patient :
http://localhost:9005/notes

* ex :
    * http://localhost:9005/notes
        * with JSON body

                    {
                      "id": "TheIdOfTheNote",
                      "patientId": "2",
                      "content": "Awesome content",
                      "date": "0001-01-01T01:01:01.000+00:00"
                    }