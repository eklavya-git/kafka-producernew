package com.eklavya.kafkaproducer.kafkaproducerControler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafkatest")
public class KafkaPublisherController {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplete;
    private static final String TOPIC="TestTopic2";


   @GetMapping("/publish/{message}")
    public  String publishedMessage(@PathVariable("message") final String message) {

       kafkaTemplete.send(TOPIC,message);
           return "Message Published" ;

    }
}
