import edu.uth.childvaccinesystem.models.Child;
import edu.uth.childvaccinesystem.services.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

package edu.uth.childvaccinesystem.controllers;



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
    public ResponseEntity<Child> getChildById(@PathVariable Long id) {
        Child child = childService.getChildById(id);
        if (child != null) {
            return ResponseEntity.ok(child);
        } else {
            return ResponseEntity.notFound().build();
        }
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
    public ResponseEntity<Void> deleteChild(@PathVariable Long id) {
        if (childService.deleteChild(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}