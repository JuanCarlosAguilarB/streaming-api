Here's the content for your `README.md` file based on your project requirements:

---

# Streaming Platform API

This project is a backend API for a streaming platform built using Spring Boot. It implements various functionalities like retrieving movies or series, rating them, and marking them as viewed. The API is documented using Swagger and can be tested through the provided endpoints.

## Why this database structure?

The database is structured with normalization in mind for simplicity and scalability. We have separated the key entities:

1. **CatalogItem**: Represents a movie or series with fields like title, genre, type (movie/series), number of views, and average score.
2. **UserRating**: Tracks individual user ratings for each catalog item, ensuring that users can only rate a movie or series once.
3. **User**: Stores user details and ensures that the same user cannot rate or view an item multiple times.
4. **Views**: Keeps track of what content has been marked as viewed by each user.

This structure makes it easy to query, ensures data integrity, and keeps the schema flexible for future growth.

## How to Run the Project

### Prerequisites

- **Java 17+**: Ensure you have Java installed.
- **Gradle**: The project uses the Gradle wrapper (`gradlew`), so you do not need to install Gradle separately.
- **Docker**: Docker is used for setting up the PostgreSQL database.

### Running the Project

1. **Clone the repository**:
   ```bash
   git clone git@github.com:JuanCarlosAguilarB/streaming-api.git 
   cd streaming-api
   ```

2. **Set up PostgreSQL with Docker**:
   Create a `docker-compose.yml` file (or use the one provided) and run:
   ```bash
   docker-compose up -d
   ```

3. **Run the application with Gradle**:
   ```bash
   ./gradlew bootRun
   ```

4. **Access Swagger UI**:
   Once the project is running, access the API documentation at:
   ```
   http://localhost:8080/api-docs/swagger-ui.html
   ```

### Docker Compose Configuration

If you don’t have it, create a `docker-compose.yml` file with the following content to run a PostgreSQL container:

```yaml
version: '3'
services:
  postgres:
    image: postgres:13
    environment:
      POSTGRES_USER: your_username
      POSTGRES_PASSWORD: your_password
      POSTGRES_DB: your_database_name
    ports:
      - "5433:5432"
    volumes:
      - postgres-data:/var/lib/postgresql/data

volumes:
  postgres-data:
```

Run the following command to start the database:
```bash
docker-compose up -d
```

### Environment Variables

The database connection is configured via `application.properties`. You can override the defaults by setting the following environment variables:

```bash
export URL_DB=jdbc:postgresql://localhost:5433/your_database_name
export USERNAME_DB=your_username
export PASSWORD_DB=your_password
```

Alternatively, modify the database connection settings directly in `application.properties`.

## Endpoints Overview

- **GET /v1/catalog-item/random**: Fetch a random movie or series.
- **GET /v1/catalog-item**: Get all movies or series with sorting and filtering capabilities.
- **POST /v1/catalog-item/{id}/view**: Mark a movie or series as viewed by a user.
- **POST /v1/catalog-item/{id}/rate**: Allow a user to rate a movie or series (rating range from 1 to 5).

## Running Tests

To run the tests:

```bash
./gradlew test
```

## Technologies Used

- **Spring Boot**: Java framework for building the backend API.
- **PostgreSQL**: Relational database for storing catalog items, user ratings, and view records.
- **Hibernate**: ORM for database management and schema updates.
- **Swagger**: API documentation and testing tool.
- **Docker**: For containerized PostgreSQL setup.

---

This README provides the necessary information on the database structure, project setup, running instructions, and endpoint documentation for your project. You can extend or modify this based on your specific needs!