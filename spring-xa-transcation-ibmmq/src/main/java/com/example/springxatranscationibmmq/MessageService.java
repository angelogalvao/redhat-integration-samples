package com.example.springxatranscationibmmq;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MessageService {
    
    @Resource(name="jmsConnectionFactory")
    private ConnectionFactory factory;

    @Resource(lookup ="java:jboss/jms/test-queue")
    private Destination testQueue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    public void sendMessageJavaEE() {

        JMSContext context = factory.createContext(JMSContext.SESSION_TRANSACTED);

        JMSProducer producer = context.createProducer();

        producer.send(testQueue, "TEST MESSAGE JAVA EE");

       
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void sendMessageSpring() {

        jmsTemplate.send(testQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("TEST MESSAGE SPRING");
            }
        });
       
    }
}
