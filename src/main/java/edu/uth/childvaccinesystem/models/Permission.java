package edu.uth.childvaccinesystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "permissions") // Đổi tên bảng thành số nhiều
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String code; // VD: "MANAGE_USERS", "VIEW_REPORTS"

    @Column(name = "permission_name", nullable = false, length = 100)
    private String permissionName; // Tên chi tiết, VD: "Quản lý người dùng"

    @ManyToMany(mappedBy = "permissions")
    private Set<User> users = new HashSet<>();

    // Constructors
    public Permission() {}

    public Permission(String code, String permissionName) {
        this.code = code;
        this.permissionName = permissionName;
    }
}
