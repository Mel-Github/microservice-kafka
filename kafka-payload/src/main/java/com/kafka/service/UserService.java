package com.kafka.service;

import com.kafka.domain.User;

public interface UserService {
    User registerUser(User input);
    Iterable<User> findAll();
}
