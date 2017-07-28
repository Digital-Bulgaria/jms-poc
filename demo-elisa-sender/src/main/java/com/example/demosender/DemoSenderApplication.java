package com.example.demosender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSenderApplication {

	public static void main(String[] args) {
        SpringApplication.run(DemoSenderApplication.class, args);
    }

//    @Bean
//    public MessageConverter getMessageConverter() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        Class<?>[] classesToBeBound = {PredictionMessage.class};
//        marshaller.setClassesToBeBound(classesToBeBound);
//        MarshallingMessageConverter converter = new MarshallingMessageConverter(marshaller);
//        converter.setTargetType(MessageType.TEXT);
//        return converter;
//    }
}
