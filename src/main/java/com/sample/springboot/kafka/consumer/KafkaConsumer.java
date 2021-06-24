package com.sample.springboot.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.springboot.kafka.dto.Student;

@Component
public class KafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(groupId = "group-id-json-1", topics = "netsurfingzone-topic-1", containerFactory = "kafkaListenerContainerFactory")
	public void receivedMessage(Student message) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(message);
		if (logger.isInfoEnabled()) {
			logger.info(String.format("Json message received using Kafka listener %s", jsonString));
		}
	}
}
