# reactive-house

mvn clean package liberty:run-server


## Starting Kafka
Start Zookeeper:  
`bin/zookeeper-server-start.sh config/zookeeper.properties`

Start Kafka:  
`bin/kafka-server-start.sh config/server.properties`

Create a `test` topic:
`bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test` 

