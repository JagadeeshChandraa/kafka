package com.learn.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class KafkaProducer
{
    private KafkaTemplate<String,String> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate)
    {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message)
    {

        kafkaTemplate.send(topicName,message);
    }
}
