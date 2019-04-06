package com.kafka.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kafka.domain.User;
import com.kafka.producer.config.Sender;
import com.kafka.repository.UserRepository;
import com.kafka.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("${spring.kafka.topic.userCreated}")
    private static String USER_CREATED_TOPIC = "user_topic";



    private UserRepository userRepository;
    private Sender sender;

    @Autowired
    UserServiceImpl(UserRepository userRepository, Sender sender) {
        this.userRepository = userRepository;
        this.sender = sender;
    }

    @Override
    public User registerUser(User input) {
        User createdUser = userRepository.save(input);
        sender.send(USER_CREATED_TOPIC, createdUser);
        return createdUser;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
