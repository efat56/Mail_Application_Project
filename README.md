# REST API for a Mail_Application_Project

- We have developed this REST API for an Online Trip Management System. This API performs all the fundamental CRUD operations of any Trip Management Application platform with user validation at every step.
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

- User and Admin authentication & validation with session uuid having.
- Admin Features:
  - Administrator Role of the entire application
  - Only registered admins with valid session token can add/update/delete Package,Hotel,Route or customer from main database.
  - Admin can access the details of different Routes, Bus, Packages, TicketDetails,Feedback,Customer,Reports,etc.
- User Features:
  - A user can register himself or herself on the platform.
  - He/She can check the Packages and Hotels availabilty.
  - If Trip Package is available, can book the trip package by providing payment details.
  - After booking, he will get booking details for the whole Package inside this there will be all details regarding the ticket details ,total cost, etc.
  - If the customer want can cancel the booking.



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







