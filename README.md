# samples
Kafka sample: it allows to send a message on a kafka topic through a REST request

1. First start docker-start.cmd
2. Run SpringMain class
3. To send a message on kafka topic, create a POST request like the follow:
Url: http://localhost:9091/produce/message
Body: 
{
    "id": 12,
    "name": "John",
    "rollNumber": "0122342"
}
