# Why?
It's a kotlin __kafka__ prototype using balionis-kotlin6 (docker plugin) as baseline.

## Build

```
$ ./gradlew clean build docker
$ ./gradlew generateDockerCompose
$ ./gradlew dockerComposeUp
```

## Test

```
$ docker container ls
$ docker logs 22e52d6ffec4
$ ./gradlew run --args="producer localhost:9094 myarg1 myarg2"
$ /opt/kafka_2.13-2.6.0/bin/kafka-console-consumer.sh  --bootstrap-server localhost:9094 --topic my-requests
{"payload":{"args":["myarg1","myarg2"]}}
$ /opt/kafka_2.13-2.6.0/bin/kafka-console-consumer.sh  --bootstrap-server localhost:9094 --topic my-responses
{"payload":{"message":"myarg1"}}
```

## Clean

```
$ ./gradlew dockerComposeDown
```
