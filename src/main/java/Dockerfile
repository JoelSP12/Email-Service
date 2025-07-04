# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar (make sure this matches your actual build output)
COPY target/email-service-1.0.0.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
