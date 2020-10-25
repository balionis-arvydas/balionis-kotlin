FROM openjdk:12-jdk-alpine

WORKDIR /app

COPY balionis-kotlin6-all.jar balionis-kotlin6-all.jar

CMD [ "java", "-server",\
      "-jar", "balionis-kotlin6-all.jar",\
      "myarg1", "myarg2" ]