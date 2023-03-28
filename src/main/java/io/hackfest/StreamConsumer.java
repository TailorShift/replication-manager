package io.hackfest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hackfest.db.ProductEntity;
import io.hackfest.debezium.DebeziumMessage;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@ApplicationScoped
public class StreamConsumer {
    static final Logger logger = LoggerFactory.getLogger(StreamConsumer.class);

    @Inject
    ObjectMapper objectMapper;

    @Incoming("posupdates")
    @Transactional
    public void process(String event) {
        // predefining a Deserializer for EVERY topic in the application config is plain garbage and does not even work. WTF?
        try {
            var o = objectMapper.readValue(event, new TypeReference<DebeziumMessage<ProductEntity>>() {
            });
        } catch (JsonProcessingException e) {
            logger.error("JSON parsing failed", e);
        }
        logger.info("Got a message: {}", event);


    }
}
