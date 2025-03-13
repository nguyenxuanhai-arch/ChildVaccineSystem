package edu.uth.childvaccinesystem.reponsitories;

import edu.uth.childvaccinesystem.models.Child;
import edu.uth.childvaccinesystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ChildReponsitory extends JpaRepository<Child, Long> {

}
