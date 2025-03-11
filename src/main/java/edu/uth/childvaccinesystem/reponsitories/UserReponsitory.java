package edu.uth.childvaccinesystem.reponsitories;

import edu.uth.childvaccinesystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReponsitory extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByPhone(String phone);
    User findByEmailAndPhone(String email, String phone);
    User findByPhoneAndEmail(String phone, String email);
}