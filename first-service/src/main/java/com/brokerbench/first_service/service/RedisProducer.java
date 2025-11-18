package com.brokerbench.first_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisProducer.class);
    private final RedisTemplate<String , Object> redisTemplate;

    @Value("${redis.stream.name}")
    private String streamName;

    public  RedisProducer(RedisTemplate<String , Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void sendMessage(String message) {
        MapRecord<String,Object,Object> record = StreamRecords
                .newRecord()
                .in(streamName)
                .ofMap(Map.of("value", message));
        redisTemplate.opsForStream().add(record);
        LOGGER.info(String.format("Message sent -> %s",message));
    }

}
