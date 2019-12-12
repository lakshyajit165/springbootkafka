package com.lakshyajit.kafkapublisher.controller;

import com.lakshyajit.kafkapublisher.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class publish {

    @Autowired
    private KafkaTemplate<String, Object> template;

    private String topic = "kafka";

//    @GetMapping("/publish/{name}")
//    public String publishMessage(@PathVariable String name){
//
//        template.send(topic, "Hi "+name+" I'm published from Kafka!");
//        return "Data published";
//    }

    @GetMapping("/publish/model/{name}")
    public String publishJsonMessage(@PathVariable String name){

        User user = new User(1, name, new String[] {"Bangalore", "BTM", "House 90"} );
        template.send(topic, user);
        return "Data published";
    }




}
