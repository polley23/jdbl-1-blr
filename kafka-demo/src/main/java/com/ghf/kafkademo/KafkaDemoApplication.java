package com.ghf.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KafkaDemoApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(KafkaDemoApplication.class, args);
		KafkaReceiver kafkaReceiver = app.getBean(KafkaReceiver.class);
		KafkaSender kafkaSender = app.getBean(KafkaSender.class);
		kafkaSender.send();
	}

}
