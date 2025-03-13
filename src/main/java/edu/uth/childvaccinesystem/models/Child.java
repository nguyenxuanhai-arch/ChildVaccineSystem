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
public class Child {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dateOfBirth;

    // Default constructor
    public Child() {
    }

    // Parameterized constructor
    public Child(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return "";
    }

    public String getEmail() {
        return "";
    }

    public String getPassword() {
        return "";
    }

    public void setUsername(String username) {
    }

    public void setEmail(String email) {
    }

    public void setPassword(String password) {

    }
}