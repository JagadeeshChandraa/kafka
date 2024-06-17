package com.learn.kafka.controller;

import com.learn.kafka.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api")
@RestController
public class KafkaTopicController
{
    private KafkaProducer kafkaProducer;

    public KafkaTopicController(KafkaProducer kafkaProducer)
    {
        this.kafkaProducer = kafkaProducer;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaTopicController.class);

    //http://localhost:8080/api/publish/text
    @GetMapping("/publish/{text}")
    public ResponseEntity<String> publish(@PathVariable("text") String message)
    {

        kafkaProducer.sendMessage(message);

        return new ResponseEntity<>("message sent", HttpStatus.OK);





    }
}
