# Notes:
* This project autowires shared DTO library pojos so we need a @Configuration annotated class with @Bean methods
    * https://stackoverflow.com/questions/36010544/how-do-i-autowire-3rd-party-classes-with-annotations-in-spring

## Spring Boot:
* https://spring.io/guides/gs/rest-service/

## REST call
* Invoke-RestMethod -Method 'Post' -Uri http://localhost:8081/contact -Body '{"firstName":"Alex","lastName":"Vasquez","occupation":"software engineer","phoneNumber":"123-456-7890","emailAddress":"email@email.com"}' -ContentType 'application/json'

## // TODO
* Write unit tests
    * Parameterized tests
* Write integration tests 
    * https://spring.io/guides/gs/testing-web/
* Exception handling / controller advice
  * https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
  