import edu.uth.childvaccinesystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

package edu.uth.childvaccinesystem.reponsitories;


@Repository
public interface UserReponsitory extends JpaRepository<User, Long> {
    User findByUsername(String username);
}