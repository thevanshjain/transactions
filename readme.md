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

### Links

GitHub Repository URL

    https://github.com/thevanshjain/spring-demo

GET REQUEST

    https://springboot-transactions-heroku.herokuapp.com/transaction/

POST REQUEST

    https://springboot-transactions-heroku.herokuapp.com/transaction/
    
PUT REQUEST

    https://springboot-transactions-heroku.herokuapp.com/transaction/{id}
    
Delete REQUEST

    https://springboot-transactions-heroku.herokuapp.com/transaction/{id}

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
