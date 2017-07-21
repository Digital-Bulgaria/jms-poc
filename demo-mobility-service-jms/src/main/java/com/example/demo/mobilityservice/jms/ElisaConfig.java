package com.example.demo.mobilityservice.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@EnableJms
public class ElisaConfig {

    @Bean(name = "elisaFactory")
    public JmsListenerContainerFactory getElisaListenerContainerFactory(
            DefaultJmsListenerContainerFactoryConfigurer configurer,
            @Value("${spring.activemq.elisa.broker-url}") String elisaBrokerURL) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(elisaBrokerURL);
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
