# Why?
It's a kotlin common-service1-service2 package using balionis-kotlin9 as baseline.
1. common has model. 
2. service1 is a http server which listens to rest.

## Build
```
gradle clean test build
```

## Run
```
$ ./gradlew sevice1:dockerComposeUp" 
```

## Coverage
```
$ ./gradlew sonarqube --info
$ chrome http://localhost:9000
username: admin
password: admin 
```

You can generate token used "sonar.login" (see gradle.properties) 
use http://localhost:9000/account/security/ "generate token".

## Test (local)

```
$ curl -X POST http://localhost:9090/echo \
  -H "Content-Type: application/json" \
  -d '{
        "payload":{
          "args":["arg1","arg2"]
        }
      }'
...
{"payload":{"message":"echo:arg1"}}
```
 