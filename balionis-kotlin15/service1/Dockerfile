FROM openjdk:15-jdk-alpine

WORKDIR /app

COPY ./build/libs/service1-all.jar ./

EXPOSE 8080

ENTRYPOINT java $JAVA_OPTS -jar service1-all.jar
