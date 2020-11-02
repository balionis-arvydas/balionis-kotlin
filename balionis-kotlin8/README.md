# Why?
It's a kotlin parent-child package using balionis-kotlin4 as baseline.

# Build
```
gradle clean test build
```

# Run
```
$ ./gradlew server:run --args="myarg1 myarg2" 
...
> Task :server:run
22:40:41.283 [main] DEBUG com.balionis.kotlin8.server.App - main: args=myarg1, myarg2
22:40:41.287 [main] DEBUG com.balionis.kotlin8.server.App - main: reqJson={"payload":{"args":["myarg1","myarg2"]}}
22:40:41.288 [main] DEBUG com.balionis.kotlin8.server.App - echo: reqJson={"payload":{"args":["myarg1","myarg2"]}}
22:40:41.299 [main] DEBUG com.balionis.kotlin8.server.App - echo: resJson={"payload":{"message":"echo:myarg1"}}
22:40:41.300 [main] DEBUG com.balionis.kotlin8.server.App - main: resJson={"payload":{"message":"echo:myarg1"}}
22:40:41.300 [main] DEBUG com.balionis.kotlin8.server.App - main: msg=echo:myarg1
...
```

```
$ java -Dlogback.configurationFile=logback-sample.xml \
       -jar server/build/libs/balionis-kotlin8-server-all.jar myarg1 myarg2
...
07:34:53.956 [main] INFO  com.balionis.kotlin8.server.App - main: args=myarg1, myarg2
07:34:53.973 [main] INFO  com.balionis.kotlin8.server.App - main: done. msg=echo:myarg1
```
