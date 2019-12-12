package com.lakshyajit.kafkaconsumer.controller;

import com.lakshyajit.kafkaconsumer.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaConsumer {

    User userFromTopic = null;
    @GetMapping("/consume/json")
    public User getUser(){
        return userFromTopic;
    }


    @KafkaListener(groupId = "jsonmsg", topics="kafka", containerFactory = "userKafkaListenerContainerFactory")
    public User consumeJsonMessage(User user) {
        userFromTopic = user;
        return userFromTopic;
    }
}
