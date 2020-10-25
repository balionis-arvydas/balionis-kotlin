# Why?
It's a kotlin __kafka__ prototype using balionis-kotlin6 (docker plugin) as baseline.

## Build

```
$ ./gradlew clean build docker
$ ./gradlew dockerComposeUp
```

## Test

```
$ docker exec -it 22e52d6ffec4 bash
```

## Clean

```
$ ./gradlew dockerComposeDown
```