package com.springkafkapoc.consumer;

import com.springkafkapoc.constants.EmailConstants;
import com.springkafkapoc.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/*
KAFKA consumer
 */
@Service
public class Consumer {

  private final Logger logger = LoggerFactory.getLogger(Consumer.class);

  private EmailService emailService;

  @Autowired
  public Consumer(EmailService emailService) {
    this.emailService = emailService;
  }

  @KafkaListener(topics = "files", groupId = "group_id")
  public void consume(String message) {
    logger.info(String.format("#### -> Consumed message -> %s", message));
    emailService.sendMessageWithFailedFile(EmailConstants.TARGET_EMAIL, EmailConstants.FAILED_SUBJECT, message, EmailConstants.ATTACHMENT_PATH);
  }

}
