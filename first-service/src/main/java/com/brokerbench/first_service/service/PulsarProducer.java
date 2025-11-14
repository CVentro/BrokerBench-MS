package com.brokerbench.first_service.service;

import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

@Service
public class PulsarProducer {
    private Logger LOGGER = LoggerFactory.getLogger(PulsarProducer.class);

    private PulsarTemplate<Object> template;

    @Value("${spring.pulsar.producer.topic-name}")
    private String topic;

    public PulsarProducer(PulsarTemplate<Object> template) {
        this.template = template;
    }

    public void sendMessage(String message) throws PulsarClientException {
        template.send(topic, message);
        LOGGER.info(String.format("Message sent -> %s",message));
    }

}
