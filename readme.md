## Description

In-memory Rest APIs performing CRUD operation 

### Steps to build application

To build and run the application, run the following command

- Build the application

  ```bash
  mvn clean package
  ```

- A jar file will be created in target directory (Replace curly braces and add name of jar file with extension)

  ```bash
  java -jar {name of jar file}
  ```

### Swagger Link : /swagger-ui

### Endpoints

GET REQUEST -- All : /transaction
    
GET REQUEST BY ID : /transaction/{id}

POST REQUEST : /transaction
    
PUT REQUEST : /transaction/{id}
    
Delete REQUEST : /transaction/{id}
    


SAMPLE POST REQUEST via POSTMAN:

```json
{
  "accountNumber": 123213,
  "type": "Credit",
  "amount": 2311,
  "currency": "INT",
  "accountFrom": 1124492
}
```
