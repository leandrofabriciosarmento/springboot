## Project Title: Spring Boot Products

This project is a Spring Boot application that provides a RESTful API for managing products. It's written in Java and uses SQL for data persistence. The project is built with Maven and packaged as a Docker image for easy deployment.

### Features

- CRUD operations for products.
- Integration with a SQL database for data persistence.
- Unit tests for ensuring the quality of the code.
- Swagger for API documentation and testing.
- Dockerized for easy deployment.

### How to Use

1. Build the project with Maven:

```bash
mvn clean package
```

2. Build the Docker image:

```bash
docker build -t leandrofabriciosamento/springboot .
```

3. Run the Docker image:

```bash
docker run -p 8080:8080 leandrofabriciosamento/springboot
```

The application will be available at http://localhost:8080.

The application will be available at http://localhost:8080.  
###  API Documentation
The API documentation is available at http://localhost:8080/swagger-ui.html when the application is running.  
Import into Postman
You can import the SpringBootProducts.postman_collection.json file into Postman to test the API endpoints.