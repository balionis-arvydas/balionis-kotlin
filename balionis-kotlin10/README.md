This is camunda sandbox created to test spring docker packaging. This uses balionis-kotlin9 baseline.

See https://docs.camunda.org/manual/7.14/user-guide/spring-boot-integration/ for next steps.

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
$ chrome http://localhost:8080/camunda-web/app/
username: demo
password: demo
``` 

```
$ curl http://localhost:8080/camunda/rest-api/process-definition
```
