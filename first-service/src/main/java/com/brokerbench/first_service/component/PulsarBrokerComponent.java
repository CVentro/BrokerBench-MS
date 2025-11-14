package com.brokerbench.first_service.component;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.enums.BrokerType;
import com.brokerbench.first_service.service.PulsarProducer;
import com.brokerbench.first_service.strategy.BrokerTypeStrategy;
import org.apache.pulsar.client.api.PulsarClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PulsarBrokerComponent implements BrokerTypeStrategy {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private PulsarProducer pulsarProducer;

    public PulsarBrokerComponent(PulsarProducer pulsarProducer) {
        this.pulsarProducer = pulsarProducer;
    }

    @Override
    public BrokerType getBrokerType() {
       return BrokerType.PULSAR;
    }

    @Override
    public void sendMessage(Message message) throws PulsarClientException {
        // TO PULSAR PRODUCER
        pulsarProducer.sendMessage(message.getMessage());
        logger.info("MESSAGE FROM PULSAR  ---- " + message.getMessage());
    }
}
