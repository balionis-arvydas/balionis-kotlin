# Why?
It's a kotlin __docker__ prototype using balionis-kotlin4 as baseline.

## Build

```
$ ./gradlew clean build docker
```

## Test

```
$ docker images 
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
balionis-kotlin6    latest              3211029ef769        29 minutes ago      343MB
```

```
$ docker run balionis-kotlin6:latest
07:53:14.431 [main] DEBUG com.balionis.kotlin6.App - main: args=myarg1, myarg2
07:53:14.435 [main] DEBUG com.balionis.kotlin6.App - main: reqJson={"payload":{"args":["myarg1","myarg2"]}}
07:53:14.438 [main] DEBUG com.balionis.kotlin6.App - echo: reqJson={"payload":{"args":["myarg1","myarg2"]}}
07:53:14.453 [main] DEBUG com.balionis.kotlin6.App - echo: resJson={"payload":{"message":"echo:myarg1"}}
07:53:14.454 [main] DEBUG com.balionis.kotlin6.App - main: resJson={"payload":{"message":"echo:myarg1"}}
07:53:14.456 [main] DEBUG com.balionis.kotlin6.App - main: msg=echo:myarg1 
```
