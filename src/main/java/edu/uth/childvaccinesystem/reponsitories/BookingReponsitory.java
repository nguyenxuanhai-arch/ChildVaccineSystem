import edu.uth.childvaccinesystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

package edu.uth.childvaccinesystem.reponsitories;


@Repository
public interface BookingReponsitory extends JpaRepository<Booking, Long> {
    // Add custom query methods if needed
}