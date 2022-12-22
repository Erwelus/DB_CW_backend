package ru.ervelus.rest.transfer;

import java.time.LocalDateTime;

public class NotificationMesssage {
    private LocalDateTime time;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
