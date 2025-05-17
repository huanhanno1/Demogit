package com.example.welcomeapp.model;

import java.time.LocalDateTime;

public class WelcomeMessage {
    private String message;
    private LocalDateTime currentTime;

    public WelcomeMessage(String message, LocalDateTime currentTime) {
        this.message = message;
        this.currentTime = currentTime;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }
}
