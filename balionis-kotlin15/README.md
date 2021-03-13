# Why?
It's a kotlin common-service1-service2 package using balionis-kotlin9 as baseline.
1. common has model. 
2. service1 is a http server which listens to rest.

# Build
```
gradle clean test build
```

# Run
```
$ ./gradlew sevice1:dockerComposeUp" 
```
