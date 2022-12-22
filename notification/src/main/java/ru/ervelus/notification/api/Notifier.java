package ru.ervelus.notification.api;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Notifier {
    private final SimpMessagingTemplate template;

    public Notifier(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void sendNotification(NotificationMessage message) {
        template.convertAndSend("/notification", message);
    }
}
