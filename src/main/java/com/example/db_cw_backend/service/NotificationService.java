package com.example.db_cw_backend.service;

import com.amazon.sqs.javamessaging.AmazonSQSMessagingClientWrapper;
import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.example.db_cw_backend.transfer.NotificationMesssage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.time.LocalDateTime;

@Service
public class NotificationService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String queueName = "notify-queue";

    private final ObjectMapper mapper;

    public NotificationService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void sendNotification() {
        NotificationMesssage notificationMesssage = new NotificationMesssage();
        notificationMesssage.setTime(LocalDateTime.now());

        try {
            SQSConnectionFactory connectionFactory = new SQSConnectionFactory(
                    new ProviderConfiguration(),
                    AmazonSQSClientBuilder.standard()
                            .withEndpointConfiguration(new EndpointConfiguration(
                                    "https://message-queue.api.cloud.yandex.net",
                                    "ru-central1"
                            ))
            );

            SQSConnection connection = connectionFactory.createConnection();
            AmazonSQSMessagingClientWrapper client = connection.getWrappedAmazonSQSClient();

            if (!client.queueExists(queueName)) {
                client.createQueue(queueName);
            }

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = session.createQueue(queueName);

            MessageProducer producer = session.createProducer(queue);

            Message message = session.createTextMessage(mapper.writeValueAsString(notificationMesssage));
            producer.send(message);
        } catch (JsonProcessingException e) {
            logger.error("Error occured while building json, not notification sent");
        } catch (JMSException e) {
            logger.error("Failed to send message to YMQ: " + e.getMessage());
        }
        logger.info("Notification message sent to queue");
    }
}
