package com.example.demo.mobilityservice.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessagingMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Objects;

@Configuration
@EnableJms
public class ElisaConfig {

    @Bean(name = "elisaFactory")
    public JmsListenerContainerFactory getElisaListenerContainerFactory(
            DefaultJmsListenerContainerFactoryConfigurer configurer,
            @Value("${elisa.broker-url}") String elisaBrokerURL) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(elisaBrokerURL);
        factory.setMessageConverter(new JaxbMessageConverter());
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    private final class JaxbMessageConverter implements MessageConverter {
        private final Jaxb2Marshaller marshaller;

        public JaxbMessageConverter() {
            this.marshaller = new Jaxb2Marshaller();
            Class<?>[] classesToBeBound = {Activity.class};
            marshaller.setClassesToBeBound(classesToBeBound);
        }

        @Override
        public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            marshaller.marshal(object, result);

            return session.createTextMessage(writer.toString());
        }

        @Override
        public Object fromMessage(Message message) throws JMSException, MessageConversionException {
            Objects.requireNonNull(message, "Message can't be null");

            if (!(message instanceof TextMessage)) {
                throw new MessageConversionException("Can't convert message of type '" + message.getClass() + "'");
            }

            TextMessage textMessage = (TextMessage) message;
            StringReader reader = new StringReader(textMessage.getText());
            StreamSource source = new StreamSource(reader);
            return marshaller.unmarshal(source);
        }
    }
}
