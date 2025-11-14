package com.brokerbench.second_service.service;

import org.apache.pulsar.client.api.PulsarClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Service;

@Service
public class PulsarConsumer {

    private static Logger logger = LoggerFactory.getLogger(PulsarConsumer.class);

    @PulsarListener(subscriptionName = "${spring.pulsar.consumer.subscription-name}",topics = "${spring.pulsar.consumer.topic-name}")
    public void consume(String message) throws PulsarClientException {
        logger.info(String.format("Consumer received message: " + message));
    }
}
