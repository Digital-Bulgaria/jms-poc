package com.example.demowmsbroker;

import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoWmsBrokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWmsBrokerApplication.class, args);
    }

    @Bean
    public BrokerService broker() throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:61617");
        broker.setPersistent(false);
        return broker;
    }
}
