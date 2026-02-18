# Auto Parts Service

## Overview
Auto Parts Service is a Spring Boot microservice that stores and retrieves auto parts data using MongoDB. It is configured via environment variables and runs on port `5050` by default.

## Tech stack
- Java
- Spring Boot
- MongoDB (Spring Data)
- Maven

## Key configuration
Configuration lives in `src/main/resources/application.properties` and uses environment variables for sensitive values.

Important environment variables:
- `MONGO_DATABASE` — MongoDB database name
- `MONGO_USER` — MongoDB username
- `MONGO_PASSWORD` — MongoDB password
- `MONGO_CLUSTER` — MongoDB cluster host (used to build the connection URI)
- `SECRET_KEY` — application secret/key (kept out of repo)

Default server settings (from `application.properties`):
- `spring.application.name=auto-parts`
- `server.port=5050`
- `server.address=0.0.0.0`

The MongoDB URI is built as:
`mongodb+srv://<MONGO_USER>:<MONGO_PASSWORD>@<MONGO_CLUSTER>/test`

## Build and run

1. Provide required environment variables (example on Linux):
export MONGO_DATABASE=auto_parts_db export MONGO_USER=myuser export MONGO_PASSWORD=mypassword export MONGO_CLUSTER=mycluster.mongodb.net export SECRET_KEY=your_secret_key

2. Build with Maven:
mvn clean package


3. Run:
mvn spring-boot:run

Service will be available at `http://0.0.0.0:5050/` (or `http://localhost:5050/`).
