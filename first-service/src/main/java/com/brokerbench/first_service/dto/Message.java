package com.brokerbench.first_service.dto;

import com.brokerbench.first_service.enums.BrokerType;

public class Message {
    String message;
    BrokerType brokerType;

    public Message(String message, BrokerType brokerType) {
        this.message = message;
        this.brokerType = brokerType;
    }

    public Message() {
    }

    public BrokerType getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(BrokerType brokerType) {
        this.brokerType = brokerType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
