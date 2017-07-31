package com.example.demosender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by martin.bonev on 7/19/17.
 */
@Component
public class Sender {

  private static final Logger logger = LoggerFactory.getLogger(Sender.class);
  public static final String DESTINATION_NAME = "elisa-mailbox";

  private JmsTemplate template;

  public Sender(JmsTemplate template) {
    this.template = template;
  }

  public void sendTextMessage(String text) {
    logger.info("Sending text: " + text);
    template.convertAndSend(DESTINATION_NAME, text);
  }
}
