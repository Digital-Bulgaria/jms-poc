package com.example.demo.mobilityservice.jms;

import com.example.demo.mobilityservice.jms.Email;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WmsConfig {
    @Bean(name = "wms")
    public ConnectionFactory getElisaConnectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61617");
    }

    @Bean(name = "wmsSenderTemplate")
    public JmsTemplate getJmsTemplate(
            @Qualifier("wms") ConnectionFactory connectionFactory,
            MessageConverter messageConverter) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setDefaultDestinationName("wms-mailbox");
        jmsTemplate.setMessageConverter(messageConverter);
        return jmsTemplate;
    }
}
