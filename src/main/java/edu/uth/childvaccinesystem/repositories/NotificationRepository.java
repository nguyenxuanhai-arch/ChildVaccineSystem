package edu.uth.childvaccinesystem.reponsitories;

import edu.uth.childvaccinesystem.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Add custom query methods if needed
}