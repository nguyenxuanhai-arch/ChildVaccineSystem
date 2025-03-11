import edu.uth.childvaccinesystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

package edu.uth.childvaccinesystem.reponsitories;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Add custom query methods if needed
}