package com.example.demosender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoSenderApplication {

	public static void main(String[] args) {
        SpringApplication.run(DemoSenderApplication.class, args);
    }

    @Bean
    public MessageConverter getMessageConverter() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        Class<?>[] classesToBeBound = {Activity.class};
        marshaller.setClassesToBeBound(classesToBeBound);
        MarshallingMessageConverter converter = new MarshallingMessageConverter(marshaller);
        converter.setTargetType(MessageType.TEXT);
        return converter;
    }
}
