FROM java:8
EXPOSE 8080
ADD /target/mlsaver-0.0.1-SNAPSHOT.jar mlsaver-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "mlsaver-0.0.1-SNAPSHOT.jar"]