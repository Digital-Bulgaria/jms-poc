package com.example.demo.mobilityservice.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MobilityConnector {

    private Logger logger = LoggerFactory.getLogger(MobilityConnector.class);

    private JmsTemplate wmsSenderTemplate;

    public MobilityConnector(@Qualifier("wmsSenderTemplate") JmsTemplate wmsSenderTemplate) {
        this.wmsSenderTemplate = wmsSenderTemplate;
    }

    @JmsListener(destination = "elisa-mailbox", containerFactory = "elisaFactory")
    public void handleElisaMessage(Email email) {
        logger.info("Received message from Elisa, sending it to WMS.");
        wmsSenderTemplate.convertAndSend(email);
    }
}
