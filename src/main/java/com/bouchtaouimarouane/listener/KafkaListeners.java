package com.bouchtaouimarouane.listener;

import com.bouchtaouimarouane.records.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "bouchtaouimarouane",
            groupId = "groupId",
            containerFactory = "messageFactory"
    )
    void listener(Message data) {
        System.out.println("Listener received " + data);
    }
}