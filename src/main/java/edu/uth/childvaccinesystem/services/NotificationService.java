package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.Notification;
import edu.uth.childvaccinesystem.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Lấy tất cả thông báo
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Optional<Notification> updateNotification(Long id, Notification notificationDetails) {
        return notificationRepository.findById(id).map(notification -> {
            notification.setMessage(notificationDetails.getMessage());
            notification.setRecipient(notificationDetails.getRecipient());
            notification.setRead(notificationDetails.isRead());
            return Optional.of(notificationRepository.save(notification));
        }).orElse(Optional.empty());
    }

    public Optional<Notification> markAsRead(Long id) {
        return notificationRepository.findById(id).map(notification -> {
            notification.setRead(true);
            return notificationRepository.save(notification);
        });
    }

    public void deleteNotification(Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
        }
    }
}
