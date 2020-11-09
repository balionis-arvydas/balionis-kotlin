This is activiti sandbox created to test spring docker packaging. This uses balionis-kotlin10 baseline.

See for next steps: 
* https://www.activiti.org/5.x/userguide/#springSpringBoot
* https://spring.io/blog/2015/03/08/getting-started-with-activiti-and-spring-boot 
* https://www.baeldung.com/spring-activiti
* https://www.baeldung.com/activiti-spring-security

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
$ curl -u admin:1234 -H "Content-Type: application/json" http://localhost:8080/repository/process-definitions
{"data":[{"id":"sample1:1:4","url":"http://localhost:8080/repository/process-definitions/sample1:1:4","key":"sample1","version":1,"name":"sample1","description":null,"tenantId":"","deploymentId":"1","deploymentUrl":"http://localhost:8080/repository/deployments/1","resource":"http://localhost:8080/repository/deployments/1/resources/sample1.bpmn20.xml","diagramResource":"http://localhost:8080/repository/deployments/1/resources/sample1.sample1.png","category":"http://www.activiti.org/processdef","graphicalNotationDefined":true,"suspended":false,"startFormDefined":false}],"total":1,"start":0,"sort":"name","order":"asc","size":1}

$ curl -u admin:1234 -H "Content-Type: application/json" http://localhost:8080/runtime/process-instances
{"data":[],"total":0,"start":0,"sort":"id","order":"asc","size":0}
``` 
