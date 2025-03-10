package edu.uth.childvaccinesystem.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Payment {
    private int id;
    private int bookingId;
    private double amount;
    private String paymentDate;

    public Payment(int id, int bookingId, double amount, String paymentDate) {
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

}
