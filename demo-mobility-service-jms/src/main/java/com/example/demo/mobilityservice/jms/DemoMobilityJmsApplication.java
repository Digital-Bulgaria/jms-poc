package com.example.demo.mobilityservice.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoMobilityJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMobilityJmsApplication.class, args);
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
