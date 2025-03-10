import java.util.Date;

package edu.uth.childvaccinesystem.models;


public class Booking {
    private int id;
    private int childId;
    private int vaccineId;
    private Date bookingDate;
    private Date appointmentDate;

    public Booking() {
    }

    public Booking(int id, int childId, int vaccineId, Date bookingDate, Date appointmentDate) {
        this.id = id;
        this.childId = childId;
        this.vaccineId = vaccineId;
        this.bookingDate = bookingDate;
        this.appointmentDate = appointmentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}