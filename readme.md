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

---
## Database Migrations with Flyway

This project uses **Flyway** for database migrations. Flyway is configured to automatically manage and apply migrations to the PostgreSQL database each time the application starts.

### Naming Convention for Migration Files

Flyway expects migration files to follow a specific naming convention in order to correctly identify and apply migrations in the right order.

- **Migration files** should be placed in the `src/main/resources/db/migration` directory.
- The naming convention for migration files is:
  ```
  V{version_number}__{description}.sql
  ```
  For example:
  ```
  V1__initial_schema.sql
  V2__add_user_table.sql
  V3__add_ratings_table.sql
  ```

   - `V`: Prefix indicating a versioned migration.
   - `{version_number}`: The version number of the migration, used to order the migrations. It must be sequential.
   - `{description}`: A short description of the migration, separated from the version by double underscores (`__`).

Flyway will automatically detect new migrations and apply them based on the version number.

### Adding Test Data with `V3_data_for_test.sql`

If you need to load test data into the database (for development or testing purposes), you can use a script called `V3_data_for_test.sql`. This script is intended to insert test data and should **not** be part of the normal migrations.

To use `V3_data_for_test.sql` for loading test data, follow these steps:

1. **Place the `V3_data_for_test.sql` file** in the `src/main/resources/db/test-data/` directory (or another directory of your choice).

2. **Execute the data.sql script** manually when needed, by running the following command:

   ```bash
   psql -h localhost -p 5433 -U your_username -d your_database_name -f src/main/resources/db/test-data/V3_data_for_test.sql
   ```

   Alternatively, if using Docker, you can execute it like this:

   ```bash
   docker exec -i <container_name> psql -U your_username -d your_database_name < src/main/resources/db/test-data/data.sql
   ```

3. This ensures that the test data is only applied when explicitly needed and does not interfere with Flyway's automatic migrations.

> **Note:** It is important that `V3_data_for_test.sql` is used only for testing and development purposes and should not be part of production migrations.

---

### Docker Compose Configuration

If you don’t have it, create a `docker-compose.yml` file with the following content to run a PostgreSQL container:

```yaml
version: '3'
services:
  postgres:
    image: postgres:16.3-alpine
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

