package com.angelogalvao;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures the connection to Azure Service Bus
 * 
 * @author Ângelo Souza
 *
 */
@Configuration
public class AMQPEndpointConfiguration {
	
	@Value("${broker.url}")
    private String brokerUrl;
	
	@Bean
	AMQPConnectionDetails amqpConnection() {
	  return new AMQPConnectionDetails("amqps://" + brokerUrl + "?amqp.traceFrames=true&ampq.IdleTimeout=120000");
	}
	
}
