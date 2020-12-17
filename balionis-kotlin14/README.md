# Why?
It's a micronaut sandbox using https://micronaut.io/launch/ generator as baseline.

# Build
```
$ gradle clean test build
```

# Test
```
$ java -Dmicronaut.environments=prod -jar build/libs/balionis-kotlin14-0.1-all.jar 
$ curl -X GET http://localhost:8088/echo/World
PROD: Hello from, John!
```