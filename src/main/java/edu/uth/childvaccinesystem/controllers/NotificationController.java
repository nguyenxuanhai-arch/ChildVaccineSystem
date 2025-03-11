import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uth.childvaccinesystem.services.NotificationService;
import edu.uth.childvaccinesystem.models.Notification;
import java.util.List;

package edu.uth.childvaccinesystem.controllers;



@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    @PutMapping("/{id}")
    public Notification updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        return notificationService.updateNotification(id, notification);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
    }
}