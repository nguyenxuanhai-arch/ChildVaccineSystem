package edu.uth.childvaccinesystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Notification {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String message;
    private String recipient;
    private boolean isRead;

    public Notification() {
    }

    public Notification(String message, String recipient, boolean isRead) {
        this.message = message;
        this.recipient = recipient;
        this.isRead = isRead;
    }
    
    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }
}