package com.bouchtaouimarouane.controllers;

import com.bouchtaouimarouane.records.Message;
import com.bouchtaouimarouane.records.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("messages")
public class MessageController {
    private KafkaTemplate<String, Message> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest) {
        Message message = new Message(messageRequest.message(), LocalDateTime.now());
        kafkaTemplate.send("bouchtaouimarouane", message);
    }
}
