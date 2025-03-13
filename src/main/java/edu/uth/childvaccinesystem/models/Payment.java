package edu.uth.childvaccinesystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Payment {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long vaccineId;
    private String payerName;
    private double amount;
    private String paymentMethod;
    private LocalDate paymentDate; // Sử dụng LocalDate thay vì String

    // Constructors
    public Payment() {}

    public Payment(Long vaccineId, String payerName, double amount, String paymentMethod, LocalDate paymentDate) {
        this.vaccineId = vaccineId;
        this.payerName = payerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

}
