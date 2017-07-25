package com.example.demo.mobilityservice.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WmsConfig {

    @Bean(name = "wmsSenderTemplate")
    public JmsTemplate getJmsTemplate(
            @Value("${wms.broker-url}") String wmsBrokerURL,
            @Value("${wms.destination-name}") String wmsDestinationName) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(wmsBrokerURL);
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setDefaultDestinationName(wmsDestinationName);
        jmsTemplate.setMessageConverter(getMessageConverter());
        return jmsTemplate;
    }

    @SuppressWarnings("Duplicates")
    public MessageConverter getMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        Map<String, Class<?>> typeMappings = new HashMap<>();
        typeMappings.put("email", Email.class);
        converter.setTypeIdMappings(typeMappings);
        return converter;
    }
}
