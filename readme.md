zookeeper-server-start.sh config/zookeeper.properties
kafka-server-start.sh config/server.properties
kafka-topics.sh --zookeeper 127.0.0.1:2181 --create --topic agreementOrderTopic --partition 3 --replication-factor 1


http://localhost:8080/swagger-ui.html