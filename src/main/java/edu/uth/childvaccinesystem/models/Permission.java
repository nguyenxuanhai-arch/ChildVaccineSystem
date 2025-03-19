package edu.uth.childvaccinesystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Code", length = 50)
    private String code;

    @Column(name = "permission_name", length = 100)
    private String permissionName;

    @ManyToMany(mappedBy = "permissions")
    private Set<User> user = new HashSet<>();
}