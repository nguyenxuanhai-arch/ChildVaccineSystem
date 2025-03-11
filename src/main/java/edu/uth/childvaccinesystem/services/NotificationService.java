package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.Notification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotificationService {
    
    public void sendNotification(String message, String recipient) {
        // Logic to send notification
        System.out.println("Sending notification to " + recipient + ": " + message);
    }

    public List<Notification> getAllNotifications() {
        return List.of();
    }

    public Notification getNotificationById(Long id) {
        return null;
    }

    public Notification createNotification(Notification notification) {
        return notification;
    }

    public Notification updateNotification(Long id, Notification notification) {
        return notification;
    }

    public void deleteNotification(Long id) {

    }
}
