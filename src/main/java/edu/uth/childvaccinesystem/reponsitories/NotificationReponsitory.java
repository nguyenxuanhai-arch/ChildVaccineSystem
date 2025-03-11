import edu.uth.childvaccinesystem.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

package edu.uth.childvaccinesystem.reponsitories;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Add custom query methods if needed
}