# Product API Integration Project using Swagger, Java and Spring

## Project description

This project is a Java application that integrates with an external product API to perform operations such as querying, adding, updating and deleting products. Communication with the external API is facilitated by the use of the Swagger specification, providing clear and efficient documentation.

## Technologies Used

- **Java**: Main programming language.
- **Spring**: Main framework.
- **Swagger**: Tool for designing, creating, documenting and using RESTful web services.
- **Java libraries for HTTP requests** (e.g. Apache HttpClient, Retrofit).
- **Maven**: Dependency manager and project construction.

## Environment Setting

Before running the application, it is necessary to configure the environment. Follow the steps below:

1. Clone this repository:

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```

## Install Maven dependencies:

```bash
cd repository-name
mvn clean install
```
# Running the Application

To start the application, run the following command:

```bash
mvn spring-boot:run
```
The application will launch and be available at http://localhost:8080.

## Available Endpoints
The following are the endpoints available in the application:

- GET /products: Retrieves the list of all products.
- GET /produtos/{id}: Retrieves the details of a specific product.
- POST /products: Adds a new product.
- PUT /produtos/{id}: Updates the details of an existing product.
- DELETE /produtos/{id}: Deletes a product.

Be sure to check out the auto-generated Swagger documentation at http://localhost:8080/swagger-ui.html for details on the endpoints and how to use them.

## Contributing
If you would like to contribute to this project, feel free to create issues, send pull requests or contact the development team.