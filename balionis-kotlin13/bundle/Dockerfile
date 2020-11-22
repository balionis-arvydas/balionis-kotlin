FROM openjdk:12-jdk-alpine

WORKDIR /app

COPY bundle.jar ./myapp.jar

EXPOSE 8080

CMD [ "java", "-server", "-jar", "myapp.jar" ]