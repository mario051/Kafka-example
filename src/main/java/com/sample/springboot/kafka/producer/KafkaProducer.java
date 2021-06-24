package com.sample.springboot.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.springboot.kafka.dto.Student;

@RestController
@RequestMapping("/produce")
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Value(value = "${kafka.topic}")
	private String topicName;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping("/message")
	public String sendMessage(@RequestBody Student message) {

		try {
			kafkaTemplate.send(topicName, message);
			logger.info("json message sent succuessfully");
			return "json message sent succuessfully";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "json message NOT sent";
		}
	}

}
