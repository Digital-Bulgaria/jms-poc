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
        Activity activity = new Activity();
        activity.setYear(2017);
        activity.setKw(35);
        activity.setCount(1);
        activity.setArea(60);
        activity.setMarketNumber("48.46.2001");
        activity.setNan(41782);
        activity.setUnits(6);
        activity.setDeliveryTime(1);
        activity.setOrderCount(24);

        template.convertAndSend("elisa-mailbox", activity);
    }
}
