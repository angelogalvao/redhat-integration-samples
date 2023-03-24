package io.github.angelogalvao.example.eventnotifiersupportexample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:foo?delay=10000")
            .routeId("simple-timer-route")
            .log("Timer was called: Nothing important!!!");
    }
    
}
