package edu.uth.childvaccinesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.uth.childvaccinesystem.models.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}