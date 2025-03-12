package edu.uth.childvaccinesystem.controllers;

import edu.uth.childvaccinesystem.models.Child;
import edu.uth.childvaccinesystem.services.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/children")
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping
    public List<Child> getAllChildren() {
        return childService.getAllChildren();
    }

    @GetMapping("/{id}")
    public Optional<Child> getChildById(@PathVariable Long id) {
        return childService.getChildById(id);
    }

    @PostMapping
    public Child createChild(@RequestBody Child child) {
        return childService.createChild(child);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Child> updateChild(@PathVariable Long id, @RequestBody Child childDetails) {
        Child updatedChild = childService.updateChild(id, childDetails);
        if (updatedChild != null) {
            return ResponseEntity.ok(updatedChild);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteChild(@PathVariable Long id) {
        childService.deleteChild(id);
    }
}