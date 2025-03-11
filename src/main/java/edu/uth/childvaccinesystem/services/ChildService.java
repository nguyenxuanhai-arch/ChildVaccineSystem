package edu.uth.childvaccinesystem.services;

import edu.uth.childvaccinesystem.models.Child;

import java.util.List;

public class ChildService {
    public List<Child> getAllChildren() {
        return List.of();
    }

    public Child getChildById(Long id) {
        return null;
    }

    public Child createChild(Child child) {
        return child;
    }

    public Child updateChild(Long id, Child childDetails) {
        return childDetails;
    }

    public boolean deleteChild(Long id) {
        return false;
    }
}
