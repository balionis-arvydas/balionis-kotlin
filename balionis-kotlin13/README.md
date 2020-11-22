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
$ curl -X GET http://localhost:9200/_cluster/health
{"cluster_name":"elasticsearch","status":"green","timed_out":false,"number_of_nodes":1,...
```
