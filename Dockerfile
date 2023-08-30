FROM maven:3.6.3-jdk-11 AS build
WORKDIR /app
COPY target/springBackend-1.0.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "springBackend-1.0.0-SNAPSHOT.jar"]

COPY pom.xml .
RUN mvn clean package

COPY src ./src
CMD ["mvn", "spring-boot:run"]


