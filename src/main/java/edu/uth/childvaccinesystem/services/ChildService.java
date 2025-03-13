package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.Child;
import edu.uth.childvaccinesystem.repositories.ChildRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ChildService {
    private final ChildRepository childRepository;
    public ChildService(ChildRepository childRepository) { this.childRepository = childRepository; }

    public List<Child> getAllChildren() { return childRepository.findAll(); }

    public Optional<Child> getChildById(Long id) {
        return childRepository.findById(id);
    }

    public Child createChild(Child child) {
        return childRepository.save(child);
    }

    public Child updateChild(Long id, Child childDetails) {
        Optional<Child> childOptional = childRepository.findById(id);
        if (childOptional.isPresent()) {
            Child child = childOptional.get();
            child.setUsername(childDetails.getUsername());
            child.setEmail(childDetails.getEmail());
            child.setPassword(childDetails.getPassword());
            return childRepository.save(child);
        } else {
            throw new RuntimeException("Child not found with id " + id);
        }
    }

    public void deleteChild(Long id) {
        childRepository.deleteById(id);
    }
}
