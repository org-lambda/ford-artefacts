FROM openjdk:8
ADD build/libs/ford-0.0.1-SNAPSHOT.jar ford-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT["java", "-jar", "ford-0.0.1-SNAPSHOT.jar"]