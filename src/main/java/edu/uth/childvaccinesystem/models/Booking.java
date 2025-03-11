import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

package edu.uth.childvaccinesystem.models;


@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long childId;
    private Long vaccineId;
    private LocalDateTime appointmentDate;

    public Booking() {
    }

    public Booking(Long childId, Long vaccineId, LocalDateTime appointmentDate) {
        this.childId = childId;
        this.vaccineId = vaccineId;
        this.appointmentDate = appointmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}