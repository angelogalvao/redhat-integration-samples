package com.github.angelogalvao.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        // send message to rabiitmq
        from("timer://foo?fixedRate=true&period=5000")
            .log("Generating a simple message to RabbitMQ")
            .to("rabbitmq:test-queue");


        from("rabbitmq:test-queue")
            .log("Message received: ${body}");
    }
    
}
