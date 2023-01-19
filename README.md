Serviço para publicar mensagens (pedidos) no tópico ECOMMERCE_NEW_ORDER do Kafka

Comandos para iniciar o Kafka localmente:
1- ./zookeeper-server-start.sh ../config/zookeeper.properties 
2- ./kafka-server-start.sh ../config/server.properties 

Criando um tópico:
./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic NEW_TOPIC_HERE

Listando os tópicos:
./kafka-topics.sh --list --bootstrap-server localhost:9092

Consumindo um tópico:
./kafka-console-producer.sh --broker-list localhost:9092 --topic ECOMMERCE_NEW_ORDER

Consumindo um tópico desde o início de sua execução:
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ECOMMERCE_NEW_ORDER --from-beginning

Descrevendo os tópicos:
./kafka-topics.sh --describe --bootstrap-server localhost:9092



Obs: Executar todos os comandos dentro da pasta kafka/bin.


