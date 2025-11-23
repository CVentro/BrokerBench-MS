package com.brokerbench.first_service.component;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.enums.BrokerType;
import com.brokerbench.first_service.service.RedisProducer;
import com.brokerbench.first_service.strategy.BrokerTypeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisBrokerComponent implements BrokerTypeStrategy {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final RedisProducer redisProducer;

    public RedisBrokerComponent(RedisProducer redisProducer){
        this.redisProducer = redisProducer;
    }

    @Override
    public BrokerType getBrokerType() {
        return BrokerType.REDIS;
    }

    @Override
    public void sendMessage(Message message)  {
        redisProducer.sendMessage(message.getMessage());
        LOGGER.info("MESSAGE RECEIVED FOR REDIS STREAM   ---- " + message.getMessage());
    }
}
