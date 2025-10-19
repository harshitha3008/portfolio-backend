# Step 1: Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Fix permissions inside container
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Step 5: Copy the rest of the app source code
COPY src src

# Step 6: Build the application
RUN ./mvnw clean package -DskipTests

# Step 7: Expose port 8080 (Render will use this)
EXPOSE 8080

# Step 8: Run the app
CMD ["java", "-jar", "target/portfolio-0.0.1-SNAPSHOT.jar"]
