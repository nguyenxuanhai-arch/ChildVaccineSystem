package edu.uth.childvaccinesystem.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Booking {
    private int id;
    private int userId;
    private int vaccineId;
    private String bookingDate;

    public Booking(int id, int userId, int vaccineId, String bookingDate) {
        this.id = id;
        this.userId = userId;
        this.vaccineId = vaccineId;
        this.bookingDate = bookingDate;
    }

    public String getUserEmail() {
        return null;
    }
}
