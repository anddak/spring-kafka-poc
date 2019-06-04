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


#### Resources

https://kafka.apache.org/quickstart#quickstart_download

https://codenotfound.com/spring-kafka-consumer-producer-example.html
