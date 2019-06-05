# spring-kafka-poc
Simple spring kafka producer-consumer POC.

Project has a producer and a consumer with test to check message exchange.

## Start kafka server before using

```Application.yml```
Configured for port 9092

Navigate to kafka local folder /bin:

*start zookeper*
```zookeeper-server-start.sh config/zookeeper.properties```

*start Kafka server*
```kafka-server-start.sh config/server.properties```


# branch: kafka-with-rest-controller

- refactored POC and added a controller that takes in a producer and sends the message to the consumer 
- sending messages will display in the logs of spring boot

- zookeper and kafka server must be started first (above)

- with CURL: curl -X POST -F 'message=test' http://localhost:8080/kafka/publish
- with Postman: set POST request, add http://localhost:8080/kafka/publish as address and 'message' as key in form data, while the message you want to send, as value


#### Resources

https://kafka.apache.org/quickstart#quickstart_download

https://codenotfound.com/spring-kafka-consumer-producer-example.html

https://www.confluent.io/blog/apache-kafka-spring-boot-application#one
