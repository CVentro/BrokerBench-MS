package com.brokerbench.first_service.component;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.enums.BrokerType;
import com.brokerbench.first_service.strategy.BrokerTypeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PulsarBrokerComponent implements BrokerTypeStrategy {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BrokerType getBrokerType() {
       return BrokerType.PULSAR;
    }

    @Override
    public void sendMessage(Message message) {
        // TO PULSAR PRODUCER
        logger.info("MESSAGE FROM PULSAR  ---- " + message.getMessage());
    }
}
