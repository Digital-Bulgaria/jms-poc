package com.example.demoreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by martin.bonev on 7/19/17.
 */
@Component
public class Receiver {

    private Logger logger = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "mailbox")
    public void receiveMessage(Email email) {
        logger.info("Received < {} >", email);
    }
}
