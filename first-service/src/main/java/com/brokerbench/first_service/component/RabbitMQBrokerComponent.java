package com.brokerbench.first_service.component;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.enums.BrokerType;
import com.brokerbench.first_service.strategy.BrokerTypeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQBrokerComponent implements BrokerTypeStrategy {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BrokerType getBrokerType() {
        return BrokerType.RABBITMQ;
    }

    @Override
    public void sendMessage(Message message) {
        // TO DO -- SEND KAFKA MESSAGE
        logger.info("MESSAGE RECEIVED FOR RABBITMQ   ---- " + message.getMessage());
    }

}
