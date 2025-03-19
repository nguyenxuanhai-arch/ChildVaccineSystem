package edu.uth.childvaccinesystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Child {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age ;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appoinments = new HashSet<>();
}
