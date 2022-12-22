package ru.ervelus.notification.api;

import java.time.LocalDateTime;

public class NotificationMessage {
    private LocalDateTime time;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
