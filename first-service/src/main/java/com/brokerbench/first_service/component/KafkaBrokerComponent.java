package com.brokerbench.first_service.component;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.enums.BrokerType;
import com.brokerbench.first_service.service.KafkaProducer;
import com.brokerbench.first_service.strategy.BrokerTypeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaBrokerComponent implements BrokerTypeStrategy {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private KafkaProducer kafkaProducer;

    public KafkaBrokerComponent(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public BrokerType getBrokerType() {
        return BrokerType.KAFKA;
    }

    @Override
    public void sendMessage(Message message) {
        // TO DO -- SEND KAFKA MESSAGE
        kafkaProducer.sendMessage(message.getMessage());
        logger.info("MESSAGE RECEIVED FOR KAFKA   ---- " + message.getMessage());
    }
}
