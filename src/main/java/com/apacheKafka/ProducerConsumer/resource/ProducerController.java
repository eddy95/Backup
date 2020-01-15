package com.apacheKafka.ProducerConsumer.resource;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProducerController {
	
	@PostMapping("/publishMessage/{message}")
	public void publishMessage(@PathVariable("message") String message)
	{
		    Properties properties = new Properties();
	        properties.put("bootstrap.servers", "localhost:9092");
	        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

	        KafkaProducer kafkaProducer = new KafkaProducer(properties);
	        try{ 
	            kafkaProducer.send(new ProducerRecord("topic-demo",message+"1", message ));       
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally {
	            kafkaProducer.close();
	        }
	    }
}
