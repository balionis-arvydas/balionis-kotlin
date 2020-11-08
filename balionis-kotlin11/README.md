This is activiti sandbox created to test spring docker packaging. This uses balionis-kotlin10 baseline.

See https://spring.io/blog/2015/03/08/getting-started-with-activiti-and-spring-boot for next steps.
See https://www.activiti.org/5.x/userguide/#springSpringBoot for next steps.
See https://www.baeldung.com/spring-activiti  for next steps.
See https://www.baeldung.com/activiti-spring-security  for next steps.

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
$ curl -u admin:admin -H "Content-Type: application/json" http://localhost:8080/repository/process-definitions
{"data":[{"id":"sample1:1:4","url":"http://localhost:8080/repository/process-definitions/sample1:1:4","key":"sample1","version":1,"name":"sample1","description":null,"tenantId":"","deploymentId":"1","deploymentUrl":"http://localhost:8080/repository/deployments/1","resource":"http://localhost:8080/repository/deployments/1/resources/sample1.bpmn20.xml","diagramResource":"http://localhost:8080/repository/deployments/1/resources/sample1.sample1.png","category":"http://www.activiti.org/processdef","graphicalNotationDefined":true,"suspended":false,"startFormDefined":false}],"total":1,"start":0,"sort":"name","order":"asc","size":1}
``` 
