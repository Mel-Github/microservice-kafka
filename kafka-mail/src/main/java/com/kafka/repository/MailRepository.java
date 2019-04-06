package com.kafka.repository;

import com.kafka.domain.Mail;
import org.springframework.data.repository.CrudRepository;

public interface MailRepository extends CrudRepository<Mail, Long> {
}
