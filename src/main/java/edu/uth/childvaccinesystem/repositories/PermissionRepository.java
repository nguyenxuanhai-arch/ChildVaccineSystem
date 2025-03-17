package edu.uth.childvaccinesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.uth.childvaccinesystem.models.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
