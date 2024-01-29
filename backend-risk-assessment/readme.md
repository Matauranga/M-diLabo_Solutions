# Backend Risk Assessment

Service that manages the algorithm that provides information about the patient's diabetes risk level.

It presents his result on the port : 9006

## Technologies

* Spring Boot Starter Web 3.2.1
* Spring Cloud Starter Netflix Eureka Client 4.1.0-RCI
* Spring Cloud Starter Openfeign 4.1.0-RCI

### Docker image

Use the console, go to the corresponding module directory and run the command:

        docker build -t ms-backend-risk .

## Endpoints

### Get

Get patients list :
http://localhost:9006/risk-assessment/{id}

* ex :
    * http://localhost:9006/risk-assessment/3
        * result

              {
                  "result": "InDanger"
              }