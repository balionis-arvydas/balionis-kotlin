# Why?
It's a camunda cloud sandbox using balionis-kotlin9 as baseline.

# Build
```
gradle clean test build
```

# Test
```
$ curl -X GET http://localhost:8180/engine/echo
Hello, Engine!
$ curl -X GET http://localhost:8280/workers/echo
Hello, Workers!  
```
