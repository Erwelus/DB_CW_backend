package ru.ervelus.notification.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final Notifier notifier;
    private final ObjectMapper mapper;

    public Listener(Notifier notifier, ObjectMapper mapper) {
        this.notifier = notifier;
        this.mapper = mapper;
    }

    @JmsListener(destination = "notification-queue")
    public void onMessage(String json) {
        try {
            logger.info("receive delivery task: {}", json);

            NotificationMessage message = mapper.readValue(json, NotificationMessage.class);
            notifier.sendNotification(message);
        } catch (JsonProcessingException e) {
            logger.error("Incorrect message format. Expected:\n{\n\t\"taskId\": <id>\n}");
        }
    }
}
