Serviço para publicar mensagens (pedidos) no tópico ECOMMERCE_NEW_ORDER do Kafka

Comandos para iniciar o Kafka localmente:
1- ./zookeeper-server-start.sh ../config/zookeeper.properties 
2- ./kafka-server-start.sh ../config/server.properties 

Criando um tópico:
./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic ECOMMERCE_NEW_ORDER <- (new topic here)

Listando os tópicos:
./kafka-topics.sh --list --bootstrap-server localhost:9092

Consumindo um tópico:
./kafka-console-producer.sh --broker-list localhost:9092 --topic ECOMMERCE_NEW_ORDER

Consumindo um tópico desde o início de sua execução:
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ECOMMERCE_NEW_ORDER --from-beginning

Descrevendo os tópicos:
1- ./kafka-topics.sh --describe --bootstrap-server localhost:9092
2- ./kafka-consumer-groups.sh --all-groups --bootstrap-server localhost:9092 --describe

Listando as mensagens do tópico desde o início de sua criação:
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ECOMMERCE_NEW_ORDER --from-beginning

Listando as mensagens do tópico a partir de agora em diante:
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ECOMMERCE_NEW_ORDER

Alterando a quantidade de partições de um tópico:
./kafka-topics.sh --alter --bootstrap-server localhost:9092 --topic ECOMMERCE_NEW_ORDER --partitions 3


Obs: Executar todos os comandos dentro da pasta kafka/bin.


