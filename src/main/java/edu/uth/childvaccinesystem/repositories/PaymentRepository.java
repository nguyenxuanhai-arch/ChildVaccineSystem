package edu.uth.childvaccinesystem.repositories;

import edu.uth.childvaccinesystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
