package edu.uth.childvaccinesystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uth.childvaccinesystem.models.Permission;
import edu.uth.childvaccinesystem.services.PermissionService;
import java.util.List;

@RestController
@RequestMapping("/api/per")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/permissions")
    public List<Permission> getAllPermissions() {
        return permissionService.GetAllPermissions();
    }

    @PostMapping("/permission")
    public long addPermission(@RequestBody Permission permission) {
        return permissionService.CreatePermission(permission);
    }

    @PutMapping("/permission/{id}")
    public long updatePermission(@PathVariable Long id, @RequestBody Permission permission) {
        return permissionService.UpdatePermission(id, permission);
    }

    @DeleteMapping("/permission/{id}")
    public long deletePermission(@PathVariable Long id) {
        return permissionService.deletePermission(id);
    }
}
