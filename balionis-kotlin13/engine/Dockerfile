FROM openjdk:12-jdk-alpine

WORKDIR /app

COPY balionis-kotlin13-engine.jar ./myapp.jar

EXPOSE 8080

CMD [ "java", "-server", "-jar", "myapp.jar" ]