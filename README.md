
for start zookeeper 

bin/zookeeper-server-start.sh config/zookeeper.properties

start kafka

bin/kafka-server-start.sh config/server.properties

check kafka topic using consumer

bin/kafka-console-consumer.sh --topic wiki_recentchange --from-beginning --bootstrap-server localhost:9092