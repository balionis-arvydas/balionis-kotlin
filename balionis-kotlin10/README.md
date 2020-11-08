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
$ chrome http://localhost:8080/camunda/app/
username: demo
password: demo
``` 

```
$ curl http://localhost:8080/camunda/api/engine/engine/default/process-definition 
// Cookie: JSESSIONID=70DB1A18418DED507673157D1A50FDBE 
```
