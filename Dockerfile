# === Stage 1: Build with Maven ===
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean install -DskipTests

# === Stage 2: Run the JAR ===
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy built JAR from previous stage
COPY --from=build /app/target/*.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
