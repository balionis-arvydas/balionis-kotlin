# Why?
It's a kotlin __kafka__ prototype using balionis-kotlin6 (docker plugin) as baseline.

## Build

```
$ ./gradlew clean build docker
```

## Test

```
$ docker exec -it 22e52d6ffec4 bash
$ ps auxww | grep zookeeper
$ ps auxww | grep kotlin7 
```