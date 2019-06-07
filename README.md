# spring-kafka-poc
Simple spring kafka producer-consumer POC

- master branch uses plain spring with manual bean configuration
- branch "kafka-with-rest-controller" uses spring-boot configuration
- branch "spring-kafka-with-file-read-in-and-email-alert-if-failed" uses spring boot configuration and implements a basic service to read in a file and if the file is "failed" then send an email alert with the file as the attachment

Project has a producer and a consumer with test to check message exchange.

## Start kafka server before using

```Application.yml```
Configured for port 9092

Navigate to kafka local folder:

*start zookeper*
```bin/zookeeper-server-start.sh config/zookeeper.properties```

*start Kafka server*
```bin/kafka-server-start.sh config/server.properties```


# branch: kafka-with-rest-controller

- refactored POC to configure with Spring Boot and added a controller that takes in a producer and sends the message to the consumer 
- sending messages will display in the logs of spring boot

- zookeper and kafka server must be started first (above)

- with CURL: curl -X POST -F 'message=test' http://localhost:8080/kafka/publish
- with Postman: set POST request, add http://localhost:8080/kafka/publish as address and 'message' as key in form data, while the message you want to send, as value


# branch: spring-kafka-with-file-read-in-and-email-alert-if-failed

- built on branch "kafka-with-rest-controller", updated the controller that takes in a file and if the file's name is failed.txt then -> producer -> consumer -> email notification with the file as an attachment
- sending messages will display in the logs of spring boot

- zookeper and kafka server must be started first (above)

- Postman: set POST request, add http://localhost:8080/kafka/file as address and 'file' as key in form data (set form data as file), while the "failed.txt" file as value


#### Resources

https://kafka.apache.org/quickstart#quickstart_download

https://codenotfound.com/spring-kafka-consumer-producer-example.html

https://www.confluent.io/blog/apache-kafka-spring-boot-application#one

https://www.baeldung.com/spring-email
