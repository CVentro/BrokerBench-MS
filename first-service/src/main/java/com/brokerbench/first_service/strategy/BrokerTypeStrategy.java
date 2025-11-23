package com.brokerbench.first_service.strategy;

import com.brokerbench.first_service.dto.Message;
import com.brokerbench.first_service.enums.BrokerType;


public interface BrokerTypeStrategy {
    BrokerType getBrokerType();
    void sendMessage(Message message);
}
