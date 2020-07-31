# Why?
It's a kotlin prototype project to remind me how to use spring restful and logback with kotlin. 
The baseline is balionis-kotlin0.

# Build
```
gradle clean test build
```

# Run
```
gradle demo -Dserver.port=9090 --console=plain -i
or
java -Dserver.port=9090 -jar build/libs/balionis-kotlin2.jar
```

# Test

```
gradlew clean test --console=plain -i
```
