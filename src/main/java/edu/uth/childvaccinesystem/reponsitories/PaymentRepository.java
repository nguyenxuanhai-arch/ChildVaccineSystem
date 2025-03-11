package edu.uth.childvaccinesystem.reponsitories;

import edu.uth.childvaccinesystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByPaymentId(Long paymentId);
    Payment findByVaccineId(Long vaccineId);
    Payment findByVaccineIdAndPaymentId(Long vaccineId, Long paymentId);
}