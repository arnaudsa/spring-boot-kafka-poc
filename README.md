# spring-boot-kafka-poc
Está poc foi criada para verificar como podemos consumir mensagens do kafka de um offset específico

### Pré Requisitos
* Java 11
* Kotlin
* docker
* [kafka tool](https://www.kafkatool.com/) (Gerenciador do kafka)

## Referências
https://docs.spring.io/spring-kafka/docs/current/reference/html/#kafka-listener-annotation
https://www.baeldung.com/spring-kafka

### Endpoints

Verifica se o app está no ar
```shell
curl --location --request GET 'localhost:8080/health'
```

Criar uma nova mensagem no kafka
```shell
curl --location --request POST 'localhost:8080/messages'
```

