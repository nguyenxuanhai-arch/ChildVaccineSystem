package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.Child;
import edu.uth.childvaccinesystem.reponsitories.ChildReponsitory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ChildService {
    private final ChildReponsitory childReponsitory;
    public ChildService(ChildReponsitory childReponsitory) { this.childReponsitory = childReponsitory; }

    public List<Child> getAllChildren() { return childReponsitory.findAll(); }

    public Optional<Child> getChildById(Long id) {
        return childReponsitory.findById(id);
    }

    public Child createChild(Child child) {
        return childReponsitory.save(child);
    }

    public Child updateChild(Long id, Child childDetails) {
        Optional<Child> childOptional = childReponsitory.findById(id);
        if (childOptional.isPresent()) {
            Child child = childOptional.get();
            child.setUsername(childDetails.getUsername());
            child.setEmail(childDetails.getEmail());
            child.setPassword(childDetails.getPassword());
            return childReponsitory.save(child);
        } else {
            throw new RuntimeException("Child not found with id " + id);
        }
    }

    public void deleteChild(Long id) {
        childReponsitory.deleteById(id);
    }
}
