FROM openjdk:12-jdk-alpine

WORKDIR /app

COPY balionis-kotlin9.jar ./

EXPOSE 8080

CMD [ "java", "-server", "-jar", "balionis-kotlin9.jar" ]