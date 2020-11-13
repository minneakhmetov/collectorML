FROM java:8
EXPOSE 8080
ADD /target/mlapi-0.0.1-SNAPSHOT.jar mlapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "mlapi-0.0.1-SNAPSHOT.jar"]