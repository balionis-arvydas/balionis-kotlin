# Why?
It's a camunda cloud sandbox using balionis-kotlin9 as baseline.

# Build
```
gradle clean test build
```

# Test
```
$ curl -X GET http://localhost:8180/bundle/echo
Hello, Engine!
$ curl -X GET http://localhost:8280/workers/echo
Hello, Workers! 
$ curl -X GET http://localhost:9200/_cluster/health
{"cluster_name":"elasticsearch","status":"green","timed_out":false,"number_of_nodes":1,...
...
$ curl -X GET http://localhost:8180/bundle/deploy/sample1.bpmn \
    -F 'file=@./bundle/src/test/resources/sample1.bpmn'
```

## Modeler
```
$ wget https://github.com/zeebe-io/zeebe-modeler/releases/download/v0.10.0/zeebe-modeler-0.10.0-linux-x64.tar.gz
$ tar -zxvf zeebe-modeler-0.10.0-linux-x64.tar.gz
$ ./zeebe-modeler-0.10.0-linux-x64/zeebe-modeler 
...
$ sudo apt-get install libgdk-pixbuf2.0-0
```
