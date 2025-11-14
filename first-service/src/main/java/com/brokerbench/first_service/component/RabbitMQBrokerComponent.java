package com.brokerbench.first_service.component;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.enums.BrokerType;
import com.brokerbench.first_service.service.RabbitMQProducer;
import com.brokerbench.first_service.strategy.BrokerTypeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQBrokerComponent implements BrokerTypeStrategy {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private RabbitMQProducer rabbitMQProducer;

    public RabbitMQBrokerComponent(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @Override
    public BrokerType getBrokerType() {
        return BrokerType.RABBITMQ;
    }

    @Override
    public void sendMessage(Message message) {
        // TO DO -- SEND RABBITMQ MESSAGE
        rabbitMQProducer.sendMessage(message.getMessage());
        logger.info("MESSAGE RECEIVED FOR RABBITMQ   ---- " + message.getMessage());
    }

}
