package com.kafka.service;

import com.kafka.domain.User;

public interface EmailService {
    void sendSimpleMessage(User input);
}
