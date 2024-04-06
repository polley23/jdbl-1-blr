package com.ghf.kafkademo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaReceiver {
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @KafkaListener(topics = "test2", groupId = "test-consumer-group")
    public void receive(String s){
        log.info(s);
    }
}
