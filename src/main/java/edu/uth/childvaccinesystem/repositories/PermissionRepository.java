package edu.uth.childvaccinesystem.repositories;

import edu.uth.childvaccinesystem.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByCode(String code);
}
