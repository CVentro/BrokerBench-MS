package com.brokerbench.first_service.factory;

import com.brokerbench.first_service.enums.BrokerType;
import com.brokerbench.first_service.strategy.BrokerTypeStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class BrokerFactory {

    HashMap<BrokerType , BrokerTypeStrategy> map = new HashMap<>();

    // Making a Factory of all the brokers
    BrokerFactory(List<BrokerTypeStrategy> brokerList){
        for (BrokerTypeStrategy brokerTypeStrategy : brokerList) {
            map.put(brokerTypeStrategy.getBrokerType() , brokerTypeStrategy);
        }
    }


    public BrokerTypeStrategy getBrokerType(BrokerType brokerType){
        BrokerTypeStrategy brokerTypeStrategy = map.getOrDefault(brokerType , null);
        if (brokerTypeStrategy == null) {
            throw new RuntimeException("Broker type " + brokerType + " not found");
        }

        return brokerTypeStrategy;
    }
}
