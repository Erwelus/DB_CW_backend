package ru.ervelus.notification.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestController {
    private final Notifier notifier;

    public TestController(Notifier notifier) {
        this.notifier = notifier;
    }

    @GetMapping(value = "/notify")
    public void send() {
        NotificationMessage message = new NotificationMessage();
        message.setTime(LocalDateTime.now());
        notifier.sendNotification(message);
    }
}
