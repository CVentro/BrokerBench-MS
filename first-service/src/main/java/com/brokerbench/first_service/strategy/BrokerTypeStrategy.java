package com.brokerbench.first_service.strategy;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.enums.BrokerType;
import org.apache.pulsar.client.api.PulsarClientException;


public interface BrokerTypeStrategy {
    BrokerType getBrokerType();
    void sendMessage(Message message) throws PulsarClientException;
}
