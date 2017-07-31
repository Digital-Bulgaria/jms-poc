package com.example.demo.mobilityservice.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MobilityConnector {

    private Logger logger = LoggerFactory.getLogger(MobilityConnector.class);

    private JmsTemplate wmsSenderTemplate;

    private PredictionRepository predictionRepository;

    public MobilityConnector(@Qualifier("wmsSenderTemplate") JmsTemplate wmsSenderTemplate) {
        this.wmsSenderTemplate = wmsSenderTemplate;
    }

    @JmsListener(destination = "${elisa.destination-name}", containerFactory = "elisaFactory")
    public void handleElisaMessage(PredictionMessage predictionMessage) {
        logger.info("Received message from Elisa, sending it to WMS.");

        Email email = new Email("me@test.invalid", predictionMessage.toString());
        wmsSenderTemplate.convertAndSend(email);
    }

    @Transactional
    void store(PredictionMessage message) {
        PredictionEntity entity = new PredictionEntity();
        entity.setYear(message.getYear());
        entity.setKw(message.getKw());
        entity.setCount(message.getCount());
        entity.setArea(message.getArea());
        entity.setMarketNumber(message.getMarketNumber());
        entity.setNan(message.getNan());
        entity.setUnits(message.getUnits());
        entity.setDeliveryTime(message.getDeliveryTime());
        entity.setOrderCount(message.getOrderCount());

        predictionRepository.save(entity);
    }
}
