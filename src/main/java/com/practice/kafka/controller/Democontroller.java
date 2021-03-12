package com.practice.kafka.controller;

import com.practice.kafka.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Democontroller {

    @Autowired
 KafkaTemplate<String, Book> kafkaTemplate;
    private static final String TOPIC = "newTopic";

    @PostMapping ("/publish")
    public String publishMessage(@RequestBody Book book){
        kafkaTemplate.send(TOPIC, book);
        return "published successfully";
    }
}
