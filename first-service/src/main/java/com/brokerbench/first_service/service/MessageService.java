package com.brokerbench.first_service.service;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.factory.BrokerFactory;
import com.brokerbench.first_service.strategy.BrokerTypeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private BrokerFactory brokerFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    MessageService(BrokerFactory brokerFactory) {
        this.brokerFactory = brokerFactory;
    }

    public void sendMessageService(Message message) {
        logger.info("Finding the Strategy of the recieved Broker");


        BrokerTypeStrategy brokerTypeStrategy = brokerFactory.getBrokerType(message.getBrokerType());

        brokerTypeStrategy.sendMessage(message);
    }
}
