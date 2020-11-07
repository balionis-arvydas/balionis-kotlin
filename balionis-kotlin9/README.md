This is kotlin spring boot sandbox created by https://spring.io/guides/tutorials/spring-boot-kotlin/

# Build 
```
$ ./gradlew clean build docker
```
# Run 
```
$ ./gradlew generateDockerCompose
$ ./gradlew dockerComposeUp
```

# Test
```
$ curl -X GET http://localhost:8080/api/123
{ "payload": "123" }
```
