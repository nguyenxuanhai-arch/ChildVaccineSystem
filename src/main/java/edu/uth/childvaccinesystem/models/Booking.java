package edu.uth.childvaccinesystem.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
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

}