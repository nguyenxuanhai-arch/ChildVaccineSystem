package edu.uth.childvaccinesystem.reponsitories;

import edu.uth.childvaccinesystem.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ChildReponsitory extends JpaRepository<Child, Long> {
    // Add custom query methods if needed
}
