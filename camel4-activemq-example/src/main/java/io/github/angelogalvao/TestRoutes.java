package io.github.angelogalvao;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class TestRoutes extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:hello?period={{timer.period}}")
            .routeId("activemq-producer-route")
            .setBody(constant("TEST MESSAGE"))
            .log("Sending message ${body} to queue test")
            .to("activemq:queue:test");

        from("activemq:queue:test")
            .routeId("activemq-consumer-route")
            .log("Message received on queue test: ${body}");
    }

}
