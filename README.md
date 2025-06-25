# Handloom Fashion Marketplace - Backend

## Overview
The **Handloom Fashion Marketplace Backend** is a robust and scalable REST API designed to power the platform. It enables seamless interactions between users, products, orders, and payments while ensuring data security and efficient processing

Built using **Spring Boot**, the backend follows a **microservices architecture** and integrates with **MySQL** for data storage. It supports role-based authentication and authorization for **Admin, Artisan and Buyer** users.

## Features
### User Management
- **Registration & Login** using JWT Authentication
- Role-based access control (Admin, Artisan, Buyer)
- Profile management for users

### Product Management
- CRUD operations for handloom products

### Admin Dashboard
- User account approval and monitoring
- Sales analytics and order reports
- System health and performance monitoring

## Technologies Used
- **Backend Framework:** Spring Boot
- **Database:** MySQL
- **Security:** Spring Security, JWT Authentication
- **ORM:** Hibernate

## Installation & Setup
### Prerequisites
Ensure you have the following installed:
- **Java 17 or later**
- **Maven**
- **MySQL**

### Clone the Repository
```sh
git clone https://github.com/lavenia13/BackendJFSDProject.git
cd BackendJFSDProject
```

### Configure Database
Update `application.properties` with your database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/handloom_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### Build & Run the Application
```sh
mvn clean install
mvn spring-boot:run
```
- The backend will start on **http://localhost:8080**.

