package com.example.demosender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by martin.bonev on 7/19/17.
 */
@Component
public class Sender {

    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    private JmsTemplate template;

    public Sender(JmsTemplate template) {
        this.template = template;
    }

    @Scheduled(initialDelay = 5000, fixedRate = 3000)
    public void sendMessage() {
        logger.info("Sending email message.");
        Email email = new Email("me@test.invalid", "Hello (" + LocalDateTime.now() + ")!");
        template.convertAndSend("mailbox", email);
    }
}
