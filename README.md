# REST API for a Mail_Application_Project

- We have developed this REST API for Sending Mail. This API performs all the fundamental CRUD operations of any  Trip Management Application platform with user validation at every step.
- This project is developed by team of 5 Back-End Developers during project week in Masai School.


## Tech Stack

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- PostMan
- Swagger
- Lombok

## Modules

- Login, Logout Module
- User Module
- Admin Module
- Booking Management Module
- Feedback Module
- Report Module
- Trip Package Management Module
- Route Mangement Module

## Features

- User should be able to send and receive mails
- User should able to send a mail to many persons at once
- User should able to star & delete mails
- User should able to Register to Masaimail App
- User should able to login to Masaimail App


## Installation & Run

- Before running the API server, you should update the database config inside the file.
- Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/tmsdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## AWS Deployed link

## API Root Endpoint

`https://localhost:8080/`

`http://localhost:8080/swagger-ui/`







