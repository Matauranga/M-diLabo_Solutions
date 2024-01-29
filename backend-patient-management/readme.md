# Backend Patient Management

CRUD API for patient information management
Data storage in a MySQL database.

It presents his result on the port : 9001

## Technologies

* Spring Boot Starter Data JPA 3.2.1
* Spring Boot Starter Web 3.2.1
* Spring Cloud Starter Netflix Eureka Client 4.1.0-RCI
* Spring Cloud Starter Openfeign 4.1.0-RCI
* Mysql Connector J 8.3.0
* Jakarta Validation API 3.0.2
* H2 Database 2.2.224
* DataFaker 1.6.0

### Docker image

Use the console, go to the corresponding module directory and run the command:

        docker build -t ms-backend-patient .

## Database connection

* Port = 3306
* Database name = patient
* Username = sa
* Password = sa

## Endpoints

### Get

Get patients list :
http://localhost:9001/patients

* result

        {
            "patientId": 1,
            "firstname": "Test",
            "lastname": "TestNone",
            "birthdate": "1966-12-31",
            "gender": "F",
            "address": "1 Brookside St",
            "phonenumber": "100-222-3333"
        },
        {
            "patientId": 2,
            "firstname": "Test",
            "lastname": "TestBorderline",
            "birthdate": "1945-06-24",
            "gender": "M",
            "address": "2 High St",
            "phonenumber": "200-333-4444"
        }

Get patient info :
http://localhost:9001/patients/{id}

* ex :
    * http://localhost:9001/patients/2
        * result

                {
                    "patientId": 2,
                    "firstname": "Test",
                    "lastname": "TestBorderline",
                    "birthdate": "1945-06-24",
                    "gender": "M",
                    "address": "2 High St",
                    "phonenumber": "200-333-4444"
                }

### Post

Add patient :
http://localhost:9001/patients

* ex :
    * http://localhost:9001/patients
        * with JSON body

                {
                    "firstname": "Coucou",
                    "lastname": "YEAHHH",
                    "birthdate": "1945-06-24",
                    "gender": "M",
                    "address": "2 High St",
                    "phonenumber": "200-333-4444"
                }

### Put

Edit patient info :
http://localhost:9001/patients/{id}

* ex :
    * http://localhost:9001/patients/3
        * with JSON body

                {
                    "firstname": "Modif",
                    "lastname": "Modif",
                    "birthdate": "1945-06-24",
                    "gender": "?",
                    "address": "Modif",
                    "phonenumber": "999-999-9999"
                }