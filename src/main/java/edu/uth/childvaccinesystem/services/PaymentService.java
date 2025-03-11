package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.Payment;
import edu.uth.childvaccinesystem.reponsitories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public Payment createPayment(Payment payment) {
        return payment;
    }

    public Payment updatePayment(Long id, Payment payment) {
        return payment;
    }
}