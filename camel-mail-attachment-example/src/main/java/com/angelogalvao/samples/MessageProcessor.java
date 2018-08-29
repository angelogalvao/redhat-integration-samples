package com.angelogalvao.samples;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.activation.DataHandler;
import java.util.Map;

/**
 * Just set the attachment as body.
 *
 * @author <a href="mailto:angelogalvao@gmail.com">Ângelo Galvão</a>
 */
public class MessageProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        Map<String, DataHandler> attachments = exchange.getIn().getAttachments();
        if (attachments.size() == 0)
            return; // do nothing


        for (String attachmentName : attachments.keySet()) {

            DataHandler attachment =attachments.get(attachmentName);

            exchange.getOut().setBody(attachment.getInputStream());
            return; // just the first one
        }
    }
}
