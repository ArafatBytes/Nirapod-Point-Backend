# Nirapod Point Backend

A Spring Boot application for the Nirapod Point backend service.

## Features

- Spring Boot 3.5.3
- MongoDB integration
- JWT Authentication
- Email service
- RESTful APIs
- Security configuration

## Local Development

### Prerequisites

- Java 17
- Maven 3.6+
- MongoDB (local or cloud)

### Running Locally

1. Clone the repository
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## Deployment on Railway

This application is configured for deployment on Railway platform.

### Configuration Files

- `Dockerfile`: Multi-stage Docker build for optimized container
- `railway.toml`: Railway deployment configuration
- `.dockerignore`: Optimizes Docker build context

### Environment Variables

Make sure to set the following environment variables in Railway:

- `SPRING_DATA_MONGODB_URI`: MongoDB connection string
- `SPRING_MAIL_USERNAME`: Email username
- `SPRING_MAIL_PASSWORD`: Email password

### Health Check

The application exposes a health check endpoint at `/actuator/health` for Railway's health monitoring.

## Build Information

- Java Version: 17
- Spring Boot Version: 3.5.3
- Maven Compiler Plugin: 3.14.0
