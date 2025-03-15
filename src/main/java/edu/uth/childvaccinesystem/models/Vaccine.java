package edu.uth.childvaccinesystem.models;

import jakarta.persistence.*;

@Entity
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String manufacturer;

    private String lotNumber;

    private String expirationDate;

    public Vaccine() {}

    public Vaccine(String name, String manufacturer, String lotNumber, String expirationDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.lotNumber = lotNumber;
        this.expirationDate = expirationDate;
    }

}