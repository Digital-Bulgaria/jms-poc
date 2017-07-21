package com.example.demoreceiver;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJms
public class DemoReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoReceiverApplication.class, args);
	}

    @SuppressWarnings("Duplicates")
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        Map<String, Class<?>> typeMappings = new HashMap<>();
        typeMappings.put("email", Email.class);
        converter.setTypeIdMappings(typeMappings);
        return converter;
    }
}
