# springbootkafka
Using Kafka for messaging with springboot

### To publish and consume messages using kafka
- Only json messages used here because of weird errors on normal string messages. Using json messages because of practical feasibility.

### Steps:
- start zookeeper service first: ```cd kafka -> bin/zookeeper-server-start.sh config/zookeeper.properties```
- start kafka server: ``` cd kafka ->  bin/kafka-server-start.sh config/server.properties```
- create a kafka topic: ```cd kafka -> bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka```
- monitor the kafka consumer: ``` bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kafka```
- view all the messages inside a consumer from the beginning: ``` bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kafka --from-beginning```
- delete a kafka topic: ``` bin/kafka-topics.sh --zookeeper localhost:2181 --delete --topic kafka```



