package edu.uth.childvaccinesystem.models;

import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}