package com.example.demo.mobilityservice.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.ConnectionFactory;

@Configuration
public class WmsConfig {

    @Bean(name = "wmsSenderTemplate")
    public JmsTemplate getJmsTemplate(
            MessageConverter messageConverter,
            @Value("${wms.broker-url}") String wmsBrokerURL,
            @Value("${wms.destination-name}") String wmsDestinationName) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(wmsBrokerURL);
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setDefaultDestinationName(wmsDestinationName);
        jmsTemplate.setMessageConverter(messageConverter);
        return jmsTemplate;
    }
}
