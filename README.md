# E-commerce_RESTful_API

This is a simple ecommerce API built with Spring Boot and MySQL.

## Prerequisites

- Java 8 or above
- Maven
- MySQL

## Setup

1. Clone the repository
    ```
    git clone https://github.com/erennatala/E-commerce_RESTful_API.git
    ```
2. Navigate to the project directory
    ```
    cd E-commerce_RESTful_API
    ```
3. Update the `src/main/resources/application.properties` file with your MySQL credentials
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```
4. Build the project
    ```
    mvn clean install
    ```
5. Run the project
    ```
    mvn spring-boot:run
    ```

## API Endpoints

- `GET /api/products`: Get all products
- `GET /api/products/{id}`: Get a single product by ID
- `POST /api/products`: Create a new product
- `PUT /api/products/{id}`: Update a product
- `DELETE /api/products/{id}`: Delete a product

## License

[MIT](https://choosealicense.com/licenses/mit/)
