package edu.uth.childvaccinesystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Vaccine {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacturer;
    private String lotNumber;
    private String expirationDate;

    // Constructors
    public Vaccine() {}

    public Vaccine(String name, String manufacturer, String lotNumber, String expirationDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.lotNumber = lotNumber;
        this.expirationDate = expirationDate;
    }

}