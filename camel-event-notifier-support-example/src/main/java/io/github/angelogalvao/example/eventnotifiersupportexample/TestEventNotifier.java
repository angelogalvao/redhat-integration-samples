package io.github.angelogalvao.example.eventnotifiersupportexample;

import org.apache.camel.spi.CamelEvent;
import org.apache.camel.spi.CamelEvent.CamelContextStartedEvent;
import org.apache.camel.support.EventNotifierSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Angelo Galvao
 */
@Component
public class TestEventNotifier extends EventNotifierSupport {

    private static final Logger log = LoggerFactory.getLogger(TestEventNotifier.class);

    public void notify(CamelEvent event) throws Exception {

        if (event instanceof CamelContextStartedEvent) {
            log.info("Camel Context initialized!");
        }
    }
    
}
