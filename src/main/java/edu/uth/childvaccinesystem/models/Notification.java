package edu.uth.childvaccinesystem.models;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Notification {
    private int id;
    private int userId;
    private String message;
    private String notifyDate;

    public Notification(int id, int userId, String message, String notifyDate) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.notifyDate = notifyDate;
    }
}
