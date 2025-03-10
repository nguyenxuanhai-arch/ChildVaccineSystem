package edu.uth.childvaccinesystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vaccine {
    private int id;
    private String name;
    private String description;
    private int ageRequired;

    public Vaccine(int id, String name, String description, int ageRequired) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ageRequired = ageRequired;
    }

}
