package com.brokerbench.second_service.service;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class RedisConsumer {

    private static final Logger LOGGER =  LoggerFactory.getLogger(RedisConsumer.class);

    private final RedisTemplate<String, Object> redisTemplate;

    @Value("${redis.stream.name}")
    private String streamName;

    @Value("${redis.stream.group}")
    private String group;

    @Value("${redis.stream.consumer}")
    private String consumerName;

    public RedisConsumer(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init() {
        // Create group if not exist
        try {
            redisTemplate.opsForStream().createGroup(streamName, group);
        } catch (Exception ignored) {}

        LOGGER.info("📌 Redis Stream Consumer Started...");
        new Thread(this::pollMessages).start();
    }

    private void pollMessages() {

        while (true) {

            List<MapRecord<String, Object, Object>> messages =
                    redisTemplate.opsForStream().read(
                            Consumer.from(group, consumerName),
                            StreamReadOptions.empty().block(Duration.ofSeconds(2)),
                            StreamOffset.create(streamName, ReadOffset.lastConsumed())
                    );

            if (messages != null) {
                for (MapRecord<String, Object, Object> msg : messages) {
                    LOGGER.info("📩 Received: " + msg.getValue().get("value"));


                    redisTemplate.opsForStream().acknowledge(streamName, group, msg.getId());
                }
            }
        }
    }
}
