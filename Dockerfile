# Use Eclipse Temurin Java 17 as base image
FROM eclipse-temurin:17-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

# Set working directory
WORKDIR /app

# Copy pom.xml first for better caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src src

# Build the application
RUN mvn clean package -DskipTests

# Create a new stage for runtime
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=0 /app/target/*.jar app.jar

# Expose both ports that Render might use
EXPOSE 8080 10000

# Set the entry point with dynamic port configuration
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"] 