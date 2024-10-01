FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/auto-partshop-0.0.1-SNAPSHOT.jar /app/auto-partshop-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/auto-partshop-0.0.1-SNAPSHOT.jar"]

EXPOSE 5050
