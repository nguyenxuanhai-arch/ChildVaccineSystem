package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.Permission;
import edu.uth.childvaccinesystem.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> GetAllPermissions() {
        return permissionRepository.findAll();
    }

    public long CreatePermission(Permission permission) {
        return permissionRepository.save(permission).getId();
    }

    public long UpdatePermission(Long id, Permission permissionDetails) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        permission.setPermissionName(permissionDetails.getPermissionName());
        permission.setCode(permissionDetails.getCode());

        permission = permissionRepository.save(permission);
        return permission.getId();
    }

    public long deletePermission(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        permissionRepository.delete(permission);
        return id;
    }

    public long GetPermissionsById(long id) {
        return permissionRepository.findAllById(id);
    }
}
