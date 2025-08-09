# ProductService

A Java Spring Boot microservice for managing products.  
This service handles product information, integrates with third-party product clients, and supports product-related business logic.

## Features
- CRUD operations for products and categories
- Integration with FakeStore third-party product API
- Database migrations with Flyway
- Unit tests for service and controller layers

## Technologies Used
- Java 17
- Spring Boot
- JPA/Hibernate
- MySQL
- Flyway
- Maven

## Getting Started

### Prerequisites
- Java 17+
- Maven
- MySQL database

### How to Run
1. Clone the repo:
git clone https://github.com/Muniraja321/ProductService.git


2. Configure your database settings in `src/main/resources/application.properties`.
3. Build and run the project with Maven:
mvn clean install
mvn spring-boot:run


## Testing
Run tests using Maven:
mvn test



## Author
Munir Raja  
Email: munirajanelaballi@gmail.com
