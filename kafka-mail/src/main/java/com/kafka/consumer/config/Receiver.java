package com.kafka.consumer.config;

import com.kafka.domain.User;
import com.kafka.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private EmailService emailService;

    private static String USER_CREATED_TOPIC = "user_topic";


    //    @KafkaListener(topics = "${spring.kafka.topic.userCreated}")
    @KafkaListener(topics = "user_topic")
    public void receive(User payload) {
        try {
            LOGGER.info("received payload='{}'", payload.getUsername());
            emailService.sendSimpleMessage(payload);
            latch.countDown();
        }catch(Exception ex){
            LOGGER.info("exception receiving {}", ex.getStackTrace());
        }
    }
}
