FROM openjdk:12-jdk-alpine

WORKDIR /app

COPY balionis-kotlin10.jar ./

EXPOSE 8080

CMD [ "java", "-server", "-jar", "balionis-kotlin10.jar" ]
